package com.mukha.smartmoney.controller

import com.mukha.smartmoney.entity.Transaction
import com.mukha.smartmoney.service.TransactionService
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/transactions")
class TransactionController(private val transactionService: TransactionService) {

    @GetMapping
    fun getAllTransactions(): List<Transaction> = transactionService.findAll()

    @PostMapping
    fun addTransaction(@RequestBody transaction: Transaction): ResponseEntity<Transaction> {
        val username = SecurityContextHolder.getContext().authentication.name
        val savedTransaction = transactionService.save(transaction, username)
        return ResponseEntity.ok(savedTransaction)
    }

    @PutMapping("/{id}")
    fun updateTransaction(@PathVariable id: Long, @RequestBody updatedTransaction: Transaction): Transaction = transactionService.updateTransaction(id, updatedTransaction)

    @DeleteMapping("/{id}")
    fun deleteTransaction(@PathVariable id: Long) = transactionService.deleteTransaction(id)
}