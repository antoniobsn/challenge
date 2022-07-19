package com.sequra.challenge.challenge.infra.repository.h2

import com.sequra.challenge.challenge.domain.Disbursement
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface DisbursementRepository: CrudRepository<Disbursement, UUID> {
}