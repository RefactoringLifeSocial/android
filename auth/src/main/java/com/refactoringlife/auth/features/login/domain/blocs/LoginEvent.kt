package com.refactoringlife.auth.features.login.domain.blocs

sealed class LoginEvent {
    data class Login(val email: String? = "", val password: String? = "",val token: String? = "") : LoginEvent()
}