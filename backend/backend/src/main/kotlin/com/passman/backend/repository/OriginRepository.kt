package com.passman.backend.repository

import com.passman.backend.model.OriginModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OriginRepository: JpaRepository<OriginModel, Long>