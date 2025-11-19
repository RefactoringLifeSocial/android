package com.refactoringlife.auth.features.login.domain.blocs

sealed class LoginEvent {
    data class Login(val email: String? = "", val password: String? = "") : LoginEvent()
    data class LoginGoogle(val token : String?="") : LoginEvent()
    object ClearState : LoginEvent()
}
