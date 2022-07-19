package com.sequra.challenge.challenge.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.math.RoundingMode

internal class ConditionRateTest {

    @Test
    fun `Should calculate the amount of the disbursement with a rate of 1 percent`() {

        val actual = ConditionRate.RATE1PERCENT.calculate(BigDecimal(40))
        val expected = BigDecimal.valueOf(39.60).setScale(SCALE, RoundingMode.FLOOR)

        assertEquals(expected, actual)
    }

    @Test
    fun `Should calculate the amount of the disbursement with a rate of 0,95 percent`() {

        val actual = ConditionRate.RATE095PERCENT.calculate(BigDecimal(200))
        val expected = BigDecimal.valueOf(198.10).setScale(SCALE, RoundingMode.FLOOR)

        assertEquals(expected, actual)
    }

    @Test
    fun `Should calculate the amount of the disbursement with a rate of 0,85 percent`() {

        val actual = ConditionRate.RATE085PERCENT.calculate(BigDecimal(400))
        val expected = BigDecimal.valueOf(396.59).setScale(SCALE, RoundingMode.FLOOR)

        assertEquals(expected, actual)
    }

    companion object {
        private const val SCALE = 2
    }
}