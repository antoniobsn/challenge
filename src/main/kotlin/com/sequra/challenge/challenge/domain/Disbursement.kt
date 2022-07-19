package com.sequra.challenge.challenge.domain

import org.hibernate.Hibernate
import java.math.BigDecimal
import java.util.*
import javax.persistence.*

@Entity
class Disbursement(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null,

    var done: Boolean = false,

    var amount: BigDecimal? = null,

    @OneToOne(cascade = [CascadeType.ALL], optional = false, orphanRemoval = true)
    @JoinColumn(name = "order_id", nullable = false, unique = true)
    var purchase: Purchase? = null,

    @ManyToOne(cascade = [CascadeType.ALL], optional = false)
    @JoinColumn(name = "merchant_id", nullable = false, unique = true)
    var merchant: Merchant? = null

) {

    fun calculateAmount(amount: BigDecimal): BigDecimal? {

        var calculatedAmount: BigDecimal? = null

        ConditionRate.values().forEach { conditionRate ->
            if ((amount > conditionRate.initialRage) && (amount < conditionRate.finalRage)) {
                calculatedAmount = conditionRate.calculate(amount)
            }
        }
        return calculatedAmount
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Disbursement

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()


}