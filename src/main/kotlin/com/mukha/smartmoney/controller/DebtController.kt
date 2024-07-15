package com.mukha.smartmoney.controller

import com.mukha.smartmoney.entity.Debt
import com.mukha.smartmoney.service.DebtService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/debts")
class DebtController(private val debtService: DebtService) {
    @GetMapping
    fun getAllDebts(): List<Debt> = debtService.findAll()

    @PostMapping
    fun createDebt(@RequestBody debt: Debt): Debt = debtService.save(debt)

    @PutMapping("/{id}")
    fun updateDebt(@PathVariable id: Long, @RequestBody updatedDebt: Debt): Debt = debtService.updateDebt(id, updatedDebt)

    @DeleteMapping("/{id}")
    fun deleteDebt(@PathVariable id: Long) = debtService.deleteDebt(id)
}