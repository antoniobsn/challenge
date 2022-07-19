package com.sequra.challenge.challenge.rest.response

import com.sequra.challenge.challenge.domain.Disbursement
import java.math.BigDecimal

data class DisbursementResponse(val amount: BigDecimal, val merchantResponse: MerchantResponse) {
    companion object {
        private fun modelToResponse(disbursement: Disbursement) : DisbursementResponse {
            return DisbursementResponse(
                amount = disbursement.amount!!,
                merchantResponse = MerchantResponse.modelToResponse(disbursement.merchant!!)
            )
        }

        fun modelsToResponses(disbursements: List<Disbursement>): List<DisbursementResponse> {
            val disbursementsResponse: MutableList<DisbursementResponse> = mutableListOf()
            disbursements.forEach { disbursement ->
                disbursementsResponse.add(modelToResponse(disbursement))

            }
            return disbursementsResponse.toList()
        }
    }
}