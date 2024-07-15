package com.mukha.smartmoney.controller

import com.mukha.smartmoney.entity.Reminder
import com.mukha.smartmoney.service.ReminderService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/reminders")
class ReminderController(private val reminderService: ReminderService) {
    @GetMapping
    fun getAllReminders(): List<Reminder> = reminderService.findAll()

    @PostMapping
    fun createReminder(@RequestBody reminder: Reminder): Reminder = reminderService.save(reminder)

    @PutMapping("/{id}")
    fun updateReminder(@PathVariable id: Long, @RequestBody updatedReminder: Reminder): Reminder = reminderService.updateReminder(id, updatedReminder)

    @DeleteMapping("/{id}")
    fun deleteReminder(@PathVariable id: Long) = reminderService.deleteReminder(id)
}