package com.mukha.smartmoney.service

import com.mukha.smartmoney.entity.RegularPayment
import com.mukha.smartmoney.repository.RegularPaymentRepository
import org.springframework.stereotype.Service

@Service
class RegularPaymentService(private val regularPaymentRepository: RegularPaymentRepository) {
    fun findAll(): List<RegularPayment> = regularPaymentRepository.findAll()
    fun save(regularPayment: RegularPayment): RegularPayment = regularPaymentRepository.save(regularPayment)
    fun update(id: Long, updatedPayment: RegularPayment): RegularPayment {
        val payment = regularPaymentRepository.findById(id).orElseThrow { IllegalArgumentException("Invalid payment ID") }
        return regularPaymentRepository.save(
            payment.copy(
                name = updatedPayment.name,
                amount = updatedPayment.amount,
                category = updatedPayment.category,
                startDate = updatedPayment.startDate,
                frequency = updatedPayment.frequency
            )
        )
    }
    fun delete(id: Long) = regularPaymentRepository.deleteById(id)
}