package com.passman.backend.model

import jakarta.persistence.*

@Entity
@Table(name = "origins")
data class OriginModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val originName: String,

    @Column(nullable = false)
    val originUrl: String,

    @OneToMany(mappedBy = "origin", cascade = [CascadeType.ALL], orphanRemoval = true)
    val passwords: List<PasswordModel> = mutableListOf()
)
