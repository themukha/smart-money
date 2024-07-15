package com.mukha.smartmoney.service

import com.mukha.smartmoney.entity.Account
import com.mukha.smartmoney.repository.AccountRepository
import org.springframework.stereotype.Service

@Service
class AccountService(private val accountRepository: AccountRepository) {
    fun findAll(): List<Account> = accountRepository.findAll()
    fun save(account: Account): Account = accountRepository.save(account)
    fun updateAccount(id: Long, updatedAccount: Account): Account {
        val account = accountRepository.findById(id).orElseThrow { IllegalArgumentException("Invalid account ID") }
        return accountRepository.save(
            account.copy(
                name = updatedAccount.name,
                balance = updatedAccount.balance
            )
        )
    }
    fun deleteAccount(id: Long) = accountRepository.deleteById(id)
}