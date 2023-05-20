package com.dev.mshair.application.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "preferences")
data class Preference(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "client_id")
    val client: Client,

    @ManyToOne
    @JoinColumn(name = "stylist_id")
    val stylist: Stylist,

    @ManyToOne
    @JoinColumn(name = "preferred_product_id")
    val preferredProduct: Product?,

    @Column(nullable = true)
    val notes: String?,

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now()
)