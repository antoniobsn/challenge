package com.sequra.challenge.challenge.infra.repository.h2

import com.sequra.challenge.challenge.domain.Merchant
import org.springframework.data.repository.CrudRepository
import java.util.*

interface MerchantRepository: CrudRepository<Merchant, UUID> {
}