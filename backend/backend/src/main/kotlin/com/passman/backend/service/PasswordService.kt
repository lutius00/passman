package com.passman.backend.service

import com.passman.backend.dto.PasswordRequestDTO
import com.passman.backend.model.PasswordModel
import com.passman.backend.repository.OriginRepository
import com.passman.backend.repository.PasswordRepository
import com.passman.backend.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class PasswordService(
    private val passwordRepository: PasswordRepository,
    private val userRepository: UserRepository,
    private val originRepository: OriginRepository
) {

    fun getAllPasswords(): List<PasswordModel> = passwordRepository.findAll()

    fun getPasswordById(id: Long): PasswordModel? = passwordRepository.findById(id).orElse(null)

    fun createPassword(passwordDTO: PasswordRequestDTO): PasswordModel {
        val user = userRepository.findById(passwordDTO.userId).orElseThrow { throw RuntimeException("User not found")}
        val origin = originRepository.findById(passwordDTO.originId).orElseThrow { throw RuntimeException("Origin not found")}
        val builtPassword = PasswordModel(
            user = user,
            origin = origin,
            password = passwordDTO.password
        )
        return passwordRepository.save(builtPassword)
    }

    fun updatePassword(id: Long, updatedPassword: PasswordModel): PasswordModel? {
        return if (passwordRepository.existsById(id)) {
            passwordRepository.save(updatedPassword.copy(id = id))
        } else null
    }
    fun deletePassword(id: Long) = passwordRepository.deleteById(id)
}