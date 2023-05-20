package com.dev.mshair.application.entity

import jakarta.persistence.*
import org.hibernate.Hibernate
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
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as BeautyService

        return id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}