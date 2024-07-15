package com.mukha.smartmoney.service

import com.mukha.smartmoney.dto.UserRegistrationDto
import com.mukha.smartmoney.dto.UserSuccessRegistrationDto
import com.mukha.smartmoney.entity.User
import com.mukha.smartmoney.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
) {
    fun findAll(): List<User> = userRepository.findAll()
    fun save(user: User): User = userRepository.save(user)
    fun registerUser(userRegistrationDto: UserRegistrationDto): UserSuccessRegistrationDto {
        val encodedPassword = passwordEncoder.encode(userRegistrationDto.password)
        val newUser = User(
            username = userRegistrationDto.username,
            password = encodedPassword,
            email = userRegistrationDto.email,
        )
        val createdUser = userRepository.save(newUser)
        return UserSuccessRegistrationDto(
            id = createdUser.id,
            username = createdUser.username,
            email = createdUser.email,
            createdAt = createdUser.createdAt,
        )
    }
    fun updateUser(id: Long, updatedUser: User): User {
        val user = userRepository.findById(id).orElseThrow { IllegalArgumentException("Invalid user ID") }
        return userRepository.save(
            user.copy(
                username = updatedUser.username,
                password = updatedUser.password,
                email = updatedUser.email
            )
        )
    }
    fun deleteUser(id: Long) = userRepository.deleteById(id)
}