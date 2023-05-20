package com.dev.mshair.application.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "beauty_services")
data class BeautyService(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = true)
    val description: String?,

    @Column(nullable = false)
    val duration: Int,

    @ManyToMany
    @JoinTable(
        name = "beauty_service_products",
        joinColumns = [JoinColumn(name = "beauty_service_id")],
        inverseJoinColumns = [JoinColumn(name = "product_id")]
    )
    val products: List<Product> = listOf(),

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now()
)