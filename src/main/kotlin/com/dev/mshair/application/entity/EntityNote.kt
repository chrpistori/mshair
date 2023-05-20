package com.dev.mshair.application.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "entity_notes")
data class EntityNote(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "entity_type", nullable = false)
    val entityType: String,

    @Column(name = "entity_id", nullable = false)
    val entityId: Long,

    @ManyToOne
    @JoinColumn(name = "note_id")
    val note: Note,

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now()
)