package com.mukha.smartmoney.dto

import java.time.LocalDateTime

data class UserSuccessRegistrationDto(
    val id: Long,
    val username: String,
    val email: String,
    val createdAt: LocalDateTime,
)