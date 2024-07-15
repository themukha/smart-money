package com.mukha.smartmoney.repository

import com.mukha.smartmoney.entity.Transaction
import org.springframework.data.jpa.repository.JpaRepository

interface TransactionRepository : JpaRepository<Transaction, Long>