package com.mukha.smartmoney.service

import com.mukha.smartmoney.entity.Transaction
import com.mukha.smartmoney.entity.User
import com.mukha.smartmoney.repository.TransactionRepository
import com.mukha.smartmoney.repository.UserRepository
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class TransactionService(
    private val transactionRepository: TransactionRepository,
    private val userRepository: UserRepository,
) {
    fun findAll(): List<Transaction> = transactionRepository.findAll()

    fun save(transaction: Transaction, username: String): Transaction {
        val user: User = userRepository.findByUsername(username) ?: throw UsernameNotFoundException("User not found")

        if (transaction.account.user.id != user.id) throw AccessDeniedException("Account doesn't belong to user")

        transaction.account.user = user

        return transactionRepository.save(transaction)
    }

    fun updateTransaction(id: Long, updatedTransaction: Transaction): Transaction {
        val transaction = transactionRepository.findById(id).orElseThrow { IllegalArgumentException("Invalid transaction ID") }
        return transactionRepository.save(
            transaction.copy(
                amount = updatedTransaction.amount,
                type = updatedTransaction.type,
                description = updatedTransaction.description,
                transactionDate = updatedTransaction.transactionDate
            )
        )
    }
    fun deleteTransaction(id: Long) = transactionRepository.deleteById(id)
}