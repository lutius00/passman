package com.passman.backend.repository

import com.passman.backend.model.UserModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<UserModel, Long>