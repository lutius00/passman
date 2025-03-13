package com.passman.backend.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController {
    @GetMapping
    fun homePage(): String {
        return "PassMan!!"
    }
}