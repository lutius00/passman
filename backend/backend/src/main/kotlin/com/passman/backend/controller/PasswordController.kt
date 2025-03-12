package com.passman.backend.controller

import com.passman.backend.dto.PasswordRequestDTO
import com.passman.backend.model.PasswordModel
import com.passman.backend.service.PasswordService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/passwords")
class PasswordController(
    private val passwordService: PasswordService,
) {

    @GetMapping
    fun getAllPasswords() = passwordService.getAllPasswords()

    @GetMapping("/{id}")
    fun getPasswordById(@PathVariable id: Long) = passwordService.getPasswordById(id)

    @PostMapping
    fun createUser(@RequestBody passwordDTO: PasswordRequestDTO): PasswordModel = passwordService.createPassword(passwordDTO)

    @PutMapping("/{id}")
    fun updatePassword(@PathVariable id: Long, @RequestBody updatedPassword: PasswordModel) = passwordService.updatePassword(id, updatedPassword)

    @DeleteMapping("/{id}")
    fun deletePassword(@PathVariable id: Long) = passwordService.deletePassword(id)
}