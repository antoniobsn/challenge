package com.sequra.challenge.challenge.rest.response

import com.sequra.challenge.challenge.domain.Merchant

data class MerchantResponse(
    val name: String,
    val email: String,
    val cif: String
) {
    companion object {
        fun modelToResponse(merchant: Merchant) : MerchantResponse {
            return MerchantResponse(name = merchant.name, email = merchant.email, cif = merchant.cif)
        }
    }
}