package com.mukha.smartmoney.controller

import com.mukha.smartmoney.entity.Loan
import com.mukha.smartmoney.service.LoanService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/loans")
class LoanController(private val loanService: LoanService) {
    @GetMapping
    fun getAllLoans(): List<Loan> = loanService.findAll()

    @PostMapping
    fun createLoan(@RequestBody loan: Loan): Loan = loanService.save(loan)

    @PutMapping("/{id}")
    fun updateLoan(@PathVariable id: Long, @RequestBody updatedLoan: Loan): Loan = loanService.updateLoan(id, updatedLoan)

    @DeleteMapping("/{id}")
    fun deleteLoan(@PathVariable id: Long) = loanService.deleteLoan(id)
}