package com.sequra.challenge.challenge.domain.objectmother

import com.sequra.challenge.challenge.domain.Merchant
import com.sequra.challenge.challenge.domain.Purchase
import com.sequra.challenge.challenge.domain.Shopper
import java.math.BigDecimal
import java.time.LocalDate

class OrderObjectMother {
    companion object {
        fun regular(
            merchant: Merchant = MerchantObjectMother.regular(),
            shopper: Shopper = ShopperObjectMother.regular(),
            amount: BigDecimal = BigDecimal(200),
            createdAt: LocalDate = LocalDate.parse("2018-12-12")
        ): Purchase {
            return Purchase(
                merchant = merchant,
                shopper = shopper,
                amount = amount,
                createdAt = createdAt
            )
        }

        fun withRate1Percent(
            merchant: Merchant = MerchantObjectMother.regular(),
            shopper: Shopper = ShopperObjectMother.regular(),
            amount: BigDecimal = BigDecimal(40),
            createdAt: LocalDate = LocalDate.parse("2018-12-12")
        ): Purchase {
            return Purchase(
                merchant = merchant,
                shopper = shopper,
                amount = amount,
                createdAt = createdAt
            )
        }

        fun withRate095Percent(
            merchant: Merchant = MerchantObjectMother.regular(),
            shopper: Shopper = ShopperObjectMother.regular(),
            amount: BigDecimal = BigDecimal(200),
            createdAt: LocalDate = LocalDate.parse("2018-12-12")
        ): Purchase {
            return Purchase(
                merchant = merchant,
                shopper = shopper,
                amount = amount,
                createdAt = createdAt
            )
        }

        fun withRate085Percent(
            merchant: Merchant = MerchantObjectMother.regular(),
            shopper: Shopper = ShopperObjectMother.regular(),
            amount: BigDecimal = BigDecimal(400),
            createdAt: LocalDate = LocalDate.parse("2018-12-12")
        ): Purchase {
            return Purchase(
                merchant = merchant,
                shopper = shopper,
                amount = amount,
                createdAt = createdAt
            )
        }
    }
}