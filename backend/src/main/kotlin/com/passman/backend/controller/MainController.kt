package com.passman.backend.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import java.time.LocalDateTime
import java.util.*

@Controller
class MainController {

    val searchResults: List<String> = listOf("one", "two", "three", "four", "five", "six")

    @GetMapping("/")
    fun getRoot(): String {
        return "index";
    }

    @GetMapping("/search")
    fun search(q: String, model: Model): String {
        val filtered = searchResults
            .stream()
            .filter { s: String -> s.startsWith(q.lowercase(Locale.getDefault())) }
            .toList()
        model.addAttribute("results", filtered)
        return "search :: results"
    }

    @PostMapping("/clicked")
    fun clicked(model: Model): String {
        model.addAttribute("now", LocalDateTime.now().toString())
        return "clicked :: result"
    }

    @GetMapping("/passwords")
    fun passwords(model: Model): String {
        val passwords = listOf("Github: mypass123", "Google: pass456")
        model.addAttribute("passwords", passwords)
        return "password"
    }
}