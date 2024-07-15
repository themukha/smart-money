package com.mukha.smartmoney.controller

import com.mukha.smartmoney.entity.RegularPayment
import com.mukha.smartmoney.service.RegularPaymentService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/regular-payments")
class RegularPaymentController(private val regularPaymentService: RegularPaymentService) {
    @GetMapping
    fun getAllRegularPayments(): List<RegularPayment> = regularPaymentService.findAll()

    @PostMapping
    fun createRegularPayment(@RequestBody regularPayment: RegularPayment): RegularPayment = regularPaymentService.save(regularPayment)

    @PutMapping("/{id}")
    fun updateRegularPayment(@PathVariable id: Long, @RequestBody updatedPayment: RegularPayment): RegularPayment = regularPaymentService.update(id, updatedPayment)

    @DeleteMapping("/{id}")
    fun deleteRegularPayment(@PathVariable id: Long) = regularPaymentService.delete(id)
}