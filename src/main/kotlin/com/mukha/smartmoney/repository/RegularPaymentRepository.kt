package com.mukha.smartmoney.repository

import com.mukha.smartmoney.entity.RegularPayment
import org.springframework.data.jpa.repository.JpaRepository

interface RegularPaymentRepository : JpaRepository<RegularPayment, Long>