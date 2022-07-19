package com.sequra.challenge.challenge.domain

import java.math.BigDecimal
import java.math.RoundingMode


private const val SCALE = 2

enum class ConditionRate(
    val rate: BigDecimal,
    val initialRage: BigDecimal,
    val finalRage: BigDecimal,
) {
    RATE1PERCENT(
        rate = BigDecimal(1),
        initialRage = BigDecimal(0),
        finalRage = BigDecimal(50)
    ) {
        override fun calculate(amount: BigDecimal): BigDecimal {

            val percent = (1.0 / 100.0) * amount.toDouble()

            return amount.subtract(percent.toBigDecimal()).setScale(SCALE, RoundingMode.FLOOR)
        }
    },
    RATE085PERCENT(
        rate = BigDecimal(0.85),
        initialRage = BigDecimal(50),
        finalRage = BigDecimal(300)
    ) {
        override fun calculate(amount: BigDecimal): BigDecimal {
            val percent = (0.85 / 100.0) * amount.toDouble()

            return amount.subtract(percent.toBigDecimal()).setScale(SCALE, RoundingMode.FLOOR)
        }
    },
    RATE095PERCENT(
        rate = BigDecimal(0.95),
        initialRage = BigDecimal(300),
        finalRage = BigDecimal(1000000)
    ) {
        override fun calculate(amount: BigDecimal): BigDecimal {
            val percent = (0.95 / 100.0) * amount.toDouble()

            return amount.subtract(percent.toBigDecimal()).setScale(SCALE, RoundingMode.FLOOR)
        }
    };

    abstract fun calculate(amount: BigDecimal): BigDecimal
}