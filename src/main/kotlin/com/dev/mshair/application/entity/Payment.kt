package com.dev.mshair.application.entity

import jakarta.persistence.*
import org.hibernate.Hibernate
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
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Payment

        return id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}