package com.passman.backend.dto

data class PasswordUpdateDTO(
    val userId: Long,
    val password: String,
    val passwordURL: String,
    val passwordOrigin: String,
)