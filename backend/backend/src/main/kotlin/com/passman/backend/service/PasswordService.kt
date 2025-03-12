package com.passman.backend.service

import com.passman.backend.model.PasswordModel
import com.passman.backend.repository.PasswordRepository
import org.springframework.stereotype.Service

@Service
class PasswordService(private val passwordRepository: PasswordRepository) {

    fun getAllPasswords(): List<PasswordModel> = passwordRepository.findAll()

    fun getPasswordById(id: Long): PasswordModel? = passwordRepository.findById(id).orElse(null)

    fun createPassword(passwordModel: PasswordModel) = passwordRepository.save(passwordModel)

    fun updatePassword(id: Long, updatedPassword: PasswordModel): PasswordModel? {
        return if (passwordRepository.existsById(id)) {
            passwordRepository.save(updatedPassword.copy(id = id))
        } else null
    }
    fun deletePassword(id: Long) = passwordRepository.deleteById(id)
}