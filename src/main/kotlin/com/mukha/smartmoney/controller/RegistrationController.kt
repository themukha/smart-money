package com.mukha.smartmoney.controller

import com.mukha.smartmoney.entity.User
import com.mukha.smartmoney.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/register")
class RegistrationController(
    private val userService: UserService,
    private val passwordEncoder: PasswordEncoder = BCryptPasswordEncoder(),
) {


}