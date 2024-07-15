package com.mukha.smartmoney.repository

import com.mukha.smartmoney.entity.Loan
import org.springframework.data.jpa.repository.JpaRepository

interface LoanRepository : JpaRepository<Loan, Long>