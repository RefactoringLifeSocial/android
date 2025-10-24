package com.refactoringlife.auth.features.register.domain.blocs

sealed class RegisterEvent {
    data class UserRegister(val email: String, val password: String) : RegisterEvent()
}
