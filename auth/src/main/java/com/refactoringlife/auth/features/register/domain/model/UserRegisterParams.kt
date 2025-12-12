package com.refactoringlife.auth.features.register.domain.model

data class UserRegisterParams(
    val name: String,
    val country: String,
    val address: String,
    val phone: String,
    val email: String,
    val password: String
)
