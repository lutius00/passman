package com.passman.backend.controller

import com.passman.backend.dto.PasswordCreateDTO
import com.passman.backend.dto.PasswordUpdateDTO
import com.passman.backend.model.PasswordModel
import com.passman.backend.service.PasswordService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/password")
class PasswordController(
    private val passwordService: PasswordService,
) {
    @GetMapping
    fun getAllPasswords() = passwordService.getAllPasswords()

    @GetMapping("/{id}")
    fun getPasswordById(@PathVariable id: Long) = passwordService.getPasswordById(id)

    @PostMapping
    fun createPassword(@RequestBody passwordDTO: PasswordCreateDTO): PasswordModel = passwordService.createPassword(passwordDTO)

    @PutMapping("/{id}")
    fun updatePassword(@PathVariable id: Long, @RequestBody updatedPassword: PasswordUpdateDTO) = passwordService.updatePassword(id, updatedPassword)

    @DeleteMapping("/{id}")
    fun deletePassword(@PathVariable id: Long) = passwordService.deletePassword(id)

    @GetMapping("/user/{id}")
    fun getPasswordByUserId(@PathVariable id: Long) = passwordService.getPasswordsByUserId(id)
}