package com.sequra.challenge.challenge.domain.objectmother

import com.sequra.challenge.challenge.domain.Merchant

class MerchantObjectMother {

    companion object {
        fun regular(
            name: String = "Casas Bahia",
            email: String = "casasbahia@email.com",
            cif: String = "1234567"
        ): Merchant {
            return Merchant(
                name = name,
                email = email,
                cif = cif
            )
        }
    }
}