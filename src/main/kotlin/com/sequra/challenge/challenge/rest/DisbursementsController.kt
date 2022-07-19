package com.sequra.challenge.challenge.rest

import com.sequra.challenge.challenge.application.CalculationDisbursement
import com.sequra.challenge.challenge.rest.response.DisbursementResponse
import io.swagger.annotations.ApiParam
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("disbursements")
class DisbursementsController(val calculationDisbursement: CalculationDisbursement) {

    @GetMapping
    fun byPeriodAndMerchant(
        @RequestParam(name="initialDate", required=true)
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        @ApiParam(value = "Initial date to find disbursements", required = true, defaultValue = "2022-07-18")
        initialDate: LocalDate,
        @RequestParam(name="finalDate", required=true)
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        @ApiParam(value = "Final date to find disbursements", required = true, defaultValue = "2022-07-18")
        finalDate: LocalDate,
        @RequestParam(required=false)
        @ApiParam(value = "Merchant ID", required = false, defaultValue = "1")
        merchantId: Long?
    ):List<DisbursementResponse> {
        val disbursements = calculationDisbursement.byPeriodAndMerchant(initialDate, finalDate, merchantId)
        return DisbursementResponse.modelsToResponses(disbursements)
    }
}