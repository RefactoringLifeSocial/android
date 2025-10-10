package com.refactoringlife.auth.features.login.domain.state

data class LoginState(
    val success: Boolean = false,
    val loading: Boolean = false,
    val error: Boolean = false
)