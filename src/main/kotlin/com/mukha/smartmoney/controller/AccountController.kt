package com.mukha.smartmoney.controller

import com.mukha.smartmoney.entity.Account
import com.mukha.smartmoney.service.AccountService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/accounts")
class AccountController(private val accountService: AccountService) {
    @GetMapping
    fun getAllAccounts(): List<Account> = accountService.findAll()

    @PostMapping
    fun createAccount(@RequestBody account: Account): Account = accountService.save(account)

    @PutMapping("/{id}")
    fun updateAccount(@PathVariable id: Long, @RequestBody updatedAccount: Account): Account = accountService.updateAccount(id, updatedAccount)

    @DeleteMapping("/{id}")
    fun deleteAccount(@PathVariable id: Long) = accountService.deleteAccount(id)
}