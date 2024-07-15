package com.mukha.smartmoney.service

import com.mukha.smartmoney.entity.Reminder
import com.mukha.smartmoney.repository.ReminderRepository
import org.springframework.stereotype.Service

@Service
class ReminderService(private val reminderRepository: ReminderRepository) {
    fun findAll(): List<Reminder> = reminderRepository.findAll()
    fun save(reminder: Reminder): Reminder = reminderRepository.save(reminder)
    fun updateReminder(id: Long, updatedReminder: Reminder): Reminder {
        val reminder = reminderRepository.findById(id).orElseThrow { IllegalArgumentException("Invalid reminder ID") }
        return reminderRepository.save(
            reminder.copy(
                message = updatedReminder.message,
                reminderDate = updatedReminder.reminderDate
            )
        )
    }
    fun deleteReminder(id: Long) = reminderRepository.deleteById(id)
}