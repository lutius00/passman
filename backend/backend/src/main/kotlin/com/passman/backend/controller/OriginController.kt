package com.passman.backend.controller

import com.passman.backend.model.OriginModel
import com.passman.backend.service.OriginService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/origins")
class OriginController(private val originService: OriginService) {

    @GetMapping
    fun getAllOrigins() = originService.getAllOrigins()

    @GetMapping("/{id}")
    fun getOriginById(@PathVariable id: Long) = originService.getOriginById(id)

    @PostMapping
    fun createOrigin(@RequestBody origin: OriginModel) = originService.createOrigin(origin)

    @PutMapping("/{id}")
    fun updateOrigin(@PathVariable id: Long, @RequestBody updatedOrigin: OriginModel) = originService.updateOrigin(id, updatedOrigin)

    @DeleteMapping("/{id}")
    fun deleteOrigin(@PathVariable id: Long) = originService.deleteOrigin(id)
}