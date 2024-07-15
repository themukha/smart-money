package com.mukha.smartmoney.repository

import com.mukha.smartmoney.entity.Reminder
import org.springframework.data.jpa.repository.JpaRepository

interface ReminderRepository : JpaRepository<Reminder, Long>