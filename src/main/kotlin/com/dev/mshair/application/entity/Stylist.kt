package com.dev.mshair.application.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Stylist(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val fullName: String,

    @Column(nullable = false)
    val dddPhone: String,

    @Column(nullable = false)
    val phoneNumber: String,

    val email: String? = null,

    val specialty: String? = null,

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()
)