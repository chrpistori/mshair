package com.dev.mshair.application.entity

import jakarta.persistence.*
import org.hibernate.Hibernate
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

@Entity
@Table(name = "schedules")
data class Schedule(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "stylist_id")
    val stylist: Stylist,

    @Column(name = "available_date", nullable = false)
    val availableDate: LocalDate,

    @Column(name = "available_start_time", nullable = false)
    val availableStartTime: LocalTime,

    @Column(name = "available_end_time", nullable = false)
    val availableEndTime: LocalTime,

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Schedule

        return id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}