package com.mukha.smartmoney.repository

import com.mukha.smartmoney.entity.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<Account, Long>