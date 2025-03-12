package com.passman.backend.model

import jakarta.persistence.*

@Entity
@Table(name = "passwords")
data class PasswordModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(cascade = [(CascadeType.DETACH)])
    @JoinColumn(name = "user_id", nullable = false)
    val user: UserModel,

    @Column
    val password: String,

    @Column
    val passwordURL: String,

    @Column
    val passwordOrigin: String,
)

