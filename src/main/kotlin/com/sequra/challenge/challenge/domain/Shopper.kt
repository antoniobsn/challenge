package com.sequra.challenge.challenge.domain

import java.util.*
import javax.persistence.*

@Entity
class Shopper(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    var id: Long? = null,

    val name: String,
    val email: String,
    val nif: String,

    @OneToMany(mappedBy = "shopper", cascade = [CascadeType.ALL])
    var purchases: MutableSet<Purchase> = mutableSetOf()
)