package com.sequra.challenge.challenge.application

import com.sequra.challenge.challenge.domain.Disbursement
import com.sequra.challenge.challenge.domain.Purchase
import com.sequra.challenge.challenge.infra.repository.h2.PurchaseRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.LocalDate

@Service
class CalculationDisbursement(
    val purchaseRepository: PurchaseRepository
) {
    fun byPeriodAndMerchant(
        initialDate: LocalDate,
        finalDate: LocalDate,
        merchantId: Long?
    ): List<Disbursement> {

        var purchases = purchaseRepository.findByCompletedAtGreaterThanEqualAndCompletedAtLessThanEqual(
            initialDate = initialDate,
            finalDate = finalDate
        )

        purchases = filterByMerchantId(merchantId, purchases)

        return forAllMerchants(purchases)
    }

    private fun filterByMerchantId(
        merchantId: Long?,
        purchases: List<Purchase>
    ): List<Purchase> {
        var purchasesFiltered = purchases
        if (merchantId != null) {
            purchasesFiltered = purchasesFiltered.filter { purchase -> purchase.merchant!!.id!! == merchantId }
        }
        return purchasesFiltered
    }

    private fun forAllMerchants(purchases: List<Purchase>): MutableList<Disbursement> {
        val disbursements = mutableListOf<Disbursement>()
        val merchantCalculatedSkip = mutableListOf<Long>()
        purchases.forEach { purchase ->
            if (!merchantCalculatedSkip.contains(purchase.id)) {

                val disbursement = Disbursement(merchant = purchase.merchant)

                var amount: BigDecimal? = null

                purchases.filter { purchaseFilter ->
                    purchaseFilter.merchant!!.id == purchase.merchant!!.id
                }.forEach { purchaseFiltered ->
                    amount = if (amount == null) {
                        disbursement.calculateAmount(purchaseFiltered.amount)
                    } else {
                        amount!!.add(disbursement.calculateAmount(purchaseFiltered.amount))
                    }
                    merchantCalculatedSkip.add(purchaseFiltered.id!!)
                }

                disbursement.amount = amount
                disbursements.add(disbursement)
            }
        }
        return disbursements
    }



}
