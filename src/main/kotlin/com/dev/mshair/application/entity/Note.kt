package com.dev.mshair.application.entity

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "notes")
data class Note(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "note_text", nullable = false)
    val noteText: String,

    @Column(name = "expected_date", nullable = true)
    val expectedDate: LocalDate?,

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now()
)