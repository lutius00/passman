package com.passman.backend.model

import jakarta.persistence.*

@Entity
@Table(name = "passwords")
data class PasswordModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    val user: UserModel,

    @ManyToOne
    @JoinColumn(name = "origin_id", nullable = false)
    val origin: OriginModel,

    @Column
    val password: String,
)

