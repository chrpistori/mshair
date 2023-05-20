package com.dev.mshair.application.entity

import jakarta.persistence.*
import org.hibernate.Hibernate
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
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Stylist

        return id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}