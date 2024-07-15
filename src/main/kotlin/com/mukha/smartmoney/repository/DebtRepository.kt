package com.mukha.smartmoney.repository

import com.mukha.smartmoney.entity.Debt
import org.springframework.data.jpa.repository.JpaRepository

interface DebtRepository : JpaRepository<Debt, Long>