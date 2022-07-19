package com.sequra.challenge.challenge.infra.repository.h2

import com.sequra.challenge.challenge.domain.Purchase
import org.springframework.data.repository.CrudRepository
import java.time.LocalDate
import java.util.*

interface PurchaseRepository: CrudRepository<Purchase, UUID> {

    fun findByCompletedAtGreaterThanEqualAndCompletedAtLessThanEqual(
        initialDate: LocalDate,
        finalDate: LocalDate
    ): List<Purchase>

    fun findByCreatedAtEquals(
        completedAt: LocalDate,
    ): List<Purchase>

}