package com.mukha.smartmoney.exception

import org.springframework.http.HttpStatus
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.server.ResponseStatusException

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ResponseStatusException::class)
    fun handleResponseStatusException(ex: ResponseStatusException): ErrorResponse {
        return ErrorResponse(ex.statusCode.value(), ex.reason ?: "Unexpected error")
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleValidationExceptions(ex: MethodArgumentNotValidException): ValidationErrorResponse {
        val errors = ex.bindingResult.allErrors.map { error ->
            val fieldName = (error as FieldError).field
            val errorMessage = error.defaultMessage ?: "Invalid value"
            FieldErrorDetails(fieldName, errorMessage)
        }
        return ValidationErrorResponse(HttpStatus.BAD_REQUEST.value(), "Validation failed", errors)
    }

    data class ErrorResponse(val status: Int, val message: String)

    data class ValidationErrorResponse(val status: Int, val message: String, val errors: List<FieldErrorDetails>)

    data class FieldErrorDetails(val field: String, val error: String)
}