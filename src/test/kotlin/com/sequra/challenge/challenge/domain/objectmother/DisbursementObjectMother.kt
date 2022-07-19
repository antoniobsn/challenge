package com.sequra.challenge.challenge.domain.objectmother

import com.sequra.challenge.challenge.domain.Disbursement
import com.sequra.challenge.challenge.domain.Merchant
import com.sequra.challenge.challenge.domain.Purchase

class DisbursementObjectMother {
    companion object {
        fun regular(
            merchant: Merchant = MerchantObjectMother.regular(),
            purchase: Purchase = OrderObjectMother.regular(),
            done: Boolean = false
        ): Disbursement {
            return Disbursement(
                merchant = merchant,
                purchase = purchase
            )
        }

        fun withRate1Percent(
            merchant: Merchant = MerchantObjectMother.regular(),
            purchase: Purchase = OrderObjectMother.withRate1Percent(),
            done: Boolean = false
        ): Disbursement {

            return Disbursement(
                merchant = merchant,
                purchase = purchase
            )
        }

        fun withRate085Percent(
            merchant: Merchant = MerchantObjectMother.regular(),
            purchase: Purchase = OrderObjectMother.withRate085Percent(),
            done: Boolean = false
        ): Disbursement {
            return Disbursement(
                merchant = merchant,
                purchase = purchase
            )
        }

        fun withRate095Percent(
            merchant: Merchant = MerchantObjectMother.regular(),
            purchase: Purchase = OrderObjectMother.withRate095Percent(),
            done: Boolean = false
        ): Disbursement {
            return Disbursement(
                merchant = merchant,
                purchase = purchase
            )
        }
    }
}