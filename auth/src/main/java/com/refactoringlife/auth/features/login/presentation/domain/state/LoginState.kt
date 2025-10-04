package com.refactoringlife.auth.features.login.presentation.domain.state

data class LoginState(
    val success: Boolean = false,
    val loading: Boolean = true,
    val error: Boolean = false
)