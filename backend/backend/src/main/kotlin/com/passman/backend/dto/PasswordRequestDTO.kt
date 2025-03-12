package com.passman.backend.dto

data class PasswordRequestDTO(
    val userId: Long,
    val originId: Long,
    val password: String,
)
