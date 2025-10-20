package com.refactoringlife.auth.features.register.presentation.state

import com.refactoringlife.auth.features.register.domain.model.UserRegisterModel

data class RegisterState(
    val data: UserRegisterModel? = null,
    val isError: String = "",
    val hasEmailError: Boolean = false,
    val hasPasswordError: Boolean = false,
    val hasPasswordMatchError: Boolean = false,
    val isFormValid: Boolean = false
)
