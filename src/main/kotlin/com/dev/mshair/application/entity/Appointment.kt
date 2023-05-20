package com.dev.mshair.application.entity

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

@Entity
@Table(name = "appointments")
data class Appointment(
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
    @JoinColumn(name = "beauty_service_id")
    val beautyService: BeautyService,

    @Column(name = "appointment_date", nullable = false)
    val appointmentDate: LocalDate,

    @Column(name = "appointment_time", nullable = false)
    val appointmentTime: LocalTime,

    @Column(name = "duration_minutes", nullable = false)
    val durationMinutes: Int,

    @Column(nullable = true)
    val notes: String?,

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now()
)