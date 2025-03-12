package com.passman.backend.service

import com.passman.backend.dto.PasswordCreateDTO
import com.passman.backend.dto.PasswordUpdateDTO
import com.passman.backend.model.PasswordModel
import com.passman.backend.repository.PasswordRepository
import com.passman.backend.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class PasswordService(
    private val passwordRepository: PasswordRepository,
    private val userRepository: UserRepository,
) {

    fun getAllPasswords(): List<PasswordModel> = passwordRepository.findAll()

    fun getPasswordById(id: Long): PasswordModel? = passwordRepository.findById(id).orElse(null)

    fun createPassword(passwordDTO: PasswordCreateDTO): PasswordModel {
        val user = userRepository.findById(passwordDTO.userId).orElseThrow { throw RuntimeException("User not found")}
        val builtPassword = PasswordModel(
            user = user,
            password = passwordDTO.password,
            passwordURL = passwordDTO.passwordURL,
            passwordOrigin = passwordDTO.passwordOrigin
        )
        return passwordRepository.save(builtPassword)
    }

    fun updatePassword(id: Long, updatedPassword: PasswordUpdateDTO): PasswordModel? {
        val user = userRepository.findById(updatedPassword.userId).orElseThrow { throw RuntimeException("User not found") }
        val builtPassword = PasswordModel(
            user = user,
            password = updatedPassword.password,
            passwordURL = updatedPassword.passwordURL,
            passwordOrigin = updatedPassword.passwordOrigin
        )
        return if (passwordRepository.existsById(id)) {
            passwordRepository.save(builtPassword.copy(id = id))
        } else null
    }
    fun deletePassword(id: Long) = passwordRepository.deleteById(id)

    fun getPasswordsByUserId(userId: Long): List<PasswordModel> {
        val user = userRepository.findById(userId).orElseThrow { throw RuntimeException("User not found")}
        return passwordRepository.findByUser(user)
    }
}