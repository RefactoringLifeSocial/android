package com.refactoringlife.auth.features.login.domain.state

import com.refactoringlife.auth.features.login.domain.model.UserLoginModel

data class LoginState(
    val success: Boolean = false,
    val loading: Boolean = false,
    val error: Boolean = false,
    val errorMessage: String? = "",
    val data: UserLoginModel? = null,
    val hasEmailError: Boolean = false,
    val hasPasswordError: Boolean = false,
    val isFormValid: Boolean = false
)
