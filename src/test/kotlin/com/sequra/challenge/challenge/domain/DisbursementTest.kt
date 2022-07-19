package com.sequra.challenge.challenge.domain

import com.sequra.challenge.challenge.domain.objectmother.DisbursementObjectMother
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.math.RoundingMode

internal class DisbursementTest {

    @Test
    fun `Should calculate the amount of the disbursement with a rate of 1 percent`() {

        val disbursement = DisbursementObjectMother.withRate1Percent()

        val actual = disbursement.calculateAmount(BigDecimal(40).setScale(SCALE, RoundingMode.FLOOR))
        val expected = BigDecimal.valueOf(39.60).setScale(SCALE, RoundingMode.FLOOR)

        assertEquals(expected, actual)
    }

    @Test
    fun `Should calculate the amount of the disbursement with a rate of 0,85 percent`() {

        val disbursement = DisbursementObjectMother.withRate085Percent()

        val actual = disbursement.calculateAmount(BigDecimal(400).setScale(SCALE, RoundingMode.FLOOR))
        val expected = BigDecimal.valueOf(396.20).setScale(SCALE, RoundingMode.FLOOR)

        assertEquals(expected, actual)
    }

    @Test
    fun `Should calculate the amount of the disbursement with a rate of 0,91 percent`() {

        val disbursement = DisbursementObjectMother.withRate095Percent()

        val actual = disbursement.calculateAmount(BigDecimal(200).setScale(SCALE, RoundingMode.FLOOR))
        val expected = BigDecimal.valueOf(198.29).setScale(SCALE, RoundingMode.FLOOR)

        assertEquals(expected, actual)
    }

    companion object {
        private const val SCALE = 2
    }
}