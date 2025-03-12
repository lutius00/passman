package com.passman.backend.service

import com.passman.backend.model.UserModel
import com.passman.backend.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun getAllUsers(): List<UserModel> = userRepository.findAll()

    fun getUserById(id: Long): UserModel? = userRepository.findById(id).orElse(null)

    fun createUser(userModel: UserModel): UserModel = userRepository.save(userModel)

    fun updateUser(id: Long, updatedUser: UserModel): UserModel? {
        return if (userRepository.existsById(id)) {
            userRepository.save(updatedUser.copy(id = id))
        } else null
    }
    fun deleteUser(id: Long) = userRepository.deleteById(id)
}