package com.dev.mshair.application.entity

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime
@Entity
@Table(name = "payments")
data class Payment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "appointment_id")
    val appointment: Appointment,

    @Column(nullable = false)
    val amount: Double,

    @Column(name = "payment_date", nullable = false)
    val paymentDate: LocalDate,

    @Column(name = "payment_method", nullable = false)
    val paymentMethod: String,

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now()
)