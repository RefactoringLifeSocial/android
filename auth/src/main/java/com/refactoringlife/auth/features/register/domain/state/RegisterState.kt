package com.refactoringlife.auth.features.register.domain.state

import com.refactoringlife.auth.features.register.domain.model.UserRegisterModel
import com.refactoringlife.core.common.utils.Constants.EMPTY

data class RegisterState(
    val data: UserRegisterModel? = null,
    val loading: Boolean = false,
    val error: String? = EMPTY,
    val hasEmailError: Boolean? = null,
    val hasPasswordError: Boolean? = null,
    val hasPasswordMatchError: Boolean? = null,
    val isFormValid: Boolean? = null
)
