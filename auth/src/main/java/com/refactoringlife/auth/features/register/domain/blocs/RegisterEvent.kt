package com.refactoringlife.auth.features.register.domain.blocs

sealed class RegisterEvent {
    data class UserRegister(
        val name: String,
        val country: String,
        val address: String,
        val phone: String,
        val email: String,
        val password: String,
        val confirmPassword: String
    ) : RegisterEvent()
}
