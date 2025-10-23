package com.refactoringlife.auth.features.register.presentation.state

import com.refactoringlife.auth.features.register.domain.model.UserRegisterModel

data class RegisterState(
    val success: Boolean = false,
    val loading: Boolean = false,
    val error: Boolean = false,
    val errorMessage: String? = "",
    val data: UserRegisterModel? = null,
    val hasEmailError: Boolean = false,
    val hasPasswordError: Boolean = false,
    val hasPasswordMatchError: Boolean = false,
    val isFormValid: Boolean = false
)
