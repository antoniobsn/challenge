package com.sequra.challenge.challenge.domain

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import org.hibernate.Hibernate
import org.hibernate.annotations.NotFound
import org.hibernate.annotations.NotFoundAction
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
class Purchase(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    var id: Long? = null,

    val amount: BigDecimal,
    val createdAt: LocalDate,
    val completedAt: LocalDate? = null,

    @ManyToOne(cascade = [CascadeType.ALL], /*optional = false, fetch = FetchType.LAZY*/)
    @JoinColumn(name = "shopper_id", nullable = false)
    //@NotFound(action = NotFoundAction.IGNORE)
    var shopper: Shopper? = null,

    @JsonBackReference
    @ManyToOne(cascade = [CascadeType.ALL], /*optional = false, fetch = FetchType.LAZY*/)
    @JoinColumn(name = "merchant_id", nullable = false)
    //@NotFound(action = NotFoundAction.IGNORE)
    var merchant: Merchant? = null
) {


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Purchase

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()
}