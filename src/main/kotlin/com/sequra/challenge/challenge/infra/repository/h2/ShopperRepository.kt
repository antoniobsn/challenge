package com.sequra.challenge.challenge.infra.repository.h2

import com.sequra.challenge.challenge.domain.Merchant
import com.sequra.challenge.challenge.domain.Shopper
import org.springframework.data.repository.CrudRepository
import java.util.*

interface ShopperRepository: CrudRepository<Shopper, UUID> {
}