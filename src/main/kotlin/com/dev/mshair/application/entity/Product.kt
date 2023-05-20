package com.dev.mshair.application.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "products")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = true)
    val description: String?,

    @Column(name = "stock_quantity", nullable = false)
    val stockQuantity: Int,

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now()
)