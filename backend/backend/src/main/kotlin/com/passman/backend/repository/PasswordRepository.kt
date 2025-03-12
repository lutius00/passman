package com.passman.backend.repository

import com.passman.backend.model.PasswordModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PasswordRepository: JpaRepository<PasswordModel, Long>