package com.mukha.smartmoney.controller

import com.mukha.smartmoney.dto.UserRegistrationDto
import com.mukha.smartmoney.dto.UserSuccessRegistrationDto
import com.mukha.smartmoney.entity.User
import com.mukha.smartmoney.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Controller
class AuthController(
    private val userService: UserService,
) {

    @GetMapping("/login")
    fun login(): String {
        return "login" // Вернуть имя представления для страницы логина login.html
    }

    @PostMapping("/register")
    fun register(@RequestBody userRegistrationDto: UserRegistrationDto): ResponseEntity<UserSuccessRegistrationDto> {
        val registeredUser = userService.registerUser(userRegistrationDto)
        return ResponseEntity.ok(registeredUser)
    }
}