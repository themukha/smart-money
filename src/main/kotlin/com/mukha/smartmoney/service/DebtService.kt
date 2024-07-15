package com.mukha.smartmoney.service

import com.mukha.smartmoney.entity.Debt
import com.mukha.smartmoney.repository.DebtRepository
import org.springframework.stereotype.Service

@Service
class DebtService(private val debtRepository: DebtRepository) {
    fun findAll(): List<Debt> = debtRepository.findAll()
    fun save(debt: Debt): Debt = debtRepository.save(debt)
    fun updateDebt(id: Long, updatedDebt: Debt): Debt {
        val debt = debtRepository.findById(id).orElseThrow { IllegalArgumentException("Invalid debt ID") }
        return debtRepository.save(
            debt.copy(
                amount = updatedDebt.amount,
                debtor = updatedDebt.debtor,
                dueDate = updatedDebt.dueDate,
                description = updatedDebt.description
            )
        )
    }
    fun deleteDebt(id: Long) = debtRepository.deleteById(id)
}