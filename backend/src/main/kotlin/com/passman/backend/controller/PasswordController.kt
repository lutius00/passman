package com.passman.backend.controller

import com.passman.backend.dto.PasswordCreateDTO
import com.passman.backend.dto.PasswordUpdateDTO
import com.passman.backend.model.PasswordModel
import com.passman.backend.service.PasswordService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/password")
class PasswordController(
    private val passwordService: PasswordService,
) {
    @GetMapping
    fun getAllPasswords(model: Model): String {
        val passwords = passwordService.getAllPasswords()
        model.addAttribute("passwords", passwords)
        return "index"
    }

    @GetMapping("/{id}")
    fun getPasswordById(@PathVariable id: Long) = passwordService.getPasswordById(id)

    @PostMapping
    fun createPassword(@ModelAttribute passwordDTO: PasswordCreateDTO, model: Model): String {
        passwordService.createPassword(passwordDTO)
        val passwords = passwordService.getAllPasswords()
        model.addAttribute("passwords", passwords)
        return "index"
    }

    @PutMapping("/{id}")
    fun updatePassword(@PathVariable id: Long, @RequestBody updatedPassword: PasswordUpdateDTO) = passwordService.updatePassword(id, updatedPassword)

    @DeleteMapping("/{id}")
    fun deletePassword(@PathVariable id: Long) = passwordService.deletePassword(id)

    @GetMapping("/user/{id}")
    fun getPasswordByUserId(@PathVariable id: Long) = passwordService.getPasswordsByUserId(id)
}