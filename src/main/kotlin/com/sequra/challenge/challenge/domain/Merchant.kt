package com.sequra.challenge.challenge.domain

import com.fasterxml.jackson.annotation.JsonManagedReference
import java.util.*
import javax.persistence.*

@Entity
class Merchant(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    var id: Long? = null,

    val name: String,
    val email: String,
    val cif: String,

    @OneToMany(mappedBy = "merchant", cascade = [CascadeType.ALL])
    var disbursements: MutableSet<Disbursement> = mutableSetOf(),

    @JsonManagedReference
    @OneToMany(mappedBy = "merchant", cascade = [CascadeType.ALL])
    var purchases: MutableSet<Purchase> = mutableSetOf()
)