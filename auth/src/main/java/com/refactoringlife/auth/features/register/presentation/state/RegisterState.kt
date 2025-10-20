package com.refactoringlife.auth.features.register.presentation.state

import com.refactoringlife.auth.features.register.domain.model.UserRegisterModel

data class RegisterState(
    val data: UserRegisterModel? = null,
    val isError : String = "",
    val isEmailValid: Boolean = false,
    val isPasswordValid: Boolean = false,
    val isPasswordMatchValid: Boolean = false,
    val emailError: String? = null,
    val passwordError: String? = null,
    val isFormValid: Boolean = false
)
