package com.passman.backend.service

import com.passman.backend.model.OriginModel
import com.passman.backend.repository.OriginRepository
import org.springframework.stereotype.Service

@Service
class OriginService(private val originRepository: OriginRepository) {

    fun getAllOrigins(): List<OriginModel> = originRepository.findAll()

    fun getOriginById(id: Long): OriginModel? = originRepository.findById(id).orElse(null)

    fun createOrigin(originModel: OriginModel): OriginModel = originRepository.save(originModel)

    fun updateOrigin(id: Long, updatedOrigin: OriginModel): OriginModel? {
        return if (originRepository.existsById(id)) {
            originRepository.save(updatedOrigin.copy(id = id))
        } else null
    }
    fun deleteOrigin(id: Long) = originRepository.deleteById(id)
}