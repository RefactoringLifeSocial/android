package com.refactoringlife.auth.features.login.presentation.domain.blocs

sealed class LoginEvent {
    data class Login(val email: String?, val password: String?) : LoginEvent()
}