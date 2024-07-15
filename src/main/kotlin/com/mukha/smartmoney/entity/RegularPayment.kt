package com.mukha.smartmoney.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import lombok.NoArgsConstructor

@Entity
@Table(name = "regular_payments")
@NoArgsConstructor
data class RegularPayment(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val amount: java.math.BigDecimal,

    @Column(nullable = false)
    val category: String,

    @Column(name = "start_date", nullable = false)
    val startDate: java.time.LocalDate,

    @Column(nullable = false)
    val frequency: String,

    @Column(name = "created_at", nullable = false, updatable = false)
    private val createdAt: java.time.LocalDateTime = java.time.LocalDateTime.now()
)
