package com.mukha.smartmoney.service

import com.mukha.smartmoney.entity.Loan
import com.mukha.smartmoney.repository.LoanRepository
import org.springframework.stereotype.Service

@Service
class LoanService(private val loanRepository: LoanRepository) {
    fun findAll(): List<Loan> = loanRepository.findAll()
    fun save(loan: Loan): Loan = loanRepository.save(loan)
    fun updateLoan(id: Long, updatedLoan: Loan): Loan {
        val loan = loanRepository.findById(id).orElseThrow { IllegalArgumentException("Invalid loan ID") }
        return loanRepository.save(
            loan.copy(
                amount = updatedLoan.amount,
                lender = updatedLoan.lender,
                dueDate = updatedLoan.dueDate,
                description = updatedLoan.description
            )
        )
    }
    fun deleteLoan(id: Long) = loanRepository.deleteById(id)
}