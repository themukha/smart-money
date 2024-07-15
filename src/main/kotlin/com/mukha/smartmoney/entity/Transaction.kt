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
@Table(name = "transactions")
@NoArgsConstructor
data class Transaction(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    val account: Account,

    @Column(nullable = false)
    val amount: java.math.BigDecimal,

    @Column(nullable = false)
    val type: String,

    @Column
    val description: String? = null,

    @Column(name = "transaction_date", nullable = false)
    val transactionDate: java.time.LocalDateTime = java.time.LocalDateTime.now()
)
