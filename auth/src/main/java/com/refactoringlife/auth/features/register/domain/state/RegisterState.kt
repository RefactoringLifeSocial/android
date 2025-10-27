package com.refactoringlife.auth.features.register.domain.state

import com.refactoringlife.auth.features.register.domain.model.UserRegisterModel
import com.refactoringlife.core.common.utils.Constants.EMPTY

data class RegisterState(
    val data: UserRegisterModel? = null,
    val loading: Boolean = false,
    val error: String? = EMPTY,
    val hasEmailError: Boolean = false,
    val hasPasswordError: Boolean = false,
    val hasPasswordMatchError: Boolean = false,
    val isFormValid: Boolean = false
)
