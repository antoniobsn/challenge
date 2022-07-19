package com.sequra.challenge.challenge.domain.objectmother

import com.sequra.challenge.challenge.domain.Shopper

class ShopperObjectMother {
    companion object {
        fun regular(
            name: String = "Antonio",
            email: String = "antonio@emial.com",
            nif: String = "12345678"
        ): Shopper {
            return Shopper(
                name = name,
                email = email,
                nif = nif
            )
        }
    }
}