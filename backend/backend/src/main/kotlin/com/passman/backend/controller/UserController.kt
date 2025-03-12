package com.passman.backend.controller

import com.passman.backend.model.UserModel
import com.passman.backend.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService) {

    @GetMapping
    fun getAllUsers() = userService.getAllUsers()

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long) = userService.getUserById(id)

    @PostMapping
    fun createUser(@RequestBody user: UserModel) = userService.createUser(user)

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody updatedUser: UserModel) = userService.updateUser(id, updatedUser)

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long) = userService.deleteUser(id)
}