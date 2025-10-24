package com.refactoringlife.auth.features.register.domain.state

import android.R
import com.refactoringlife.auth.features.register.domain.model.UserRegisterModel
import com.refactoringlife.auth.utils.EMPTY

data class RegisterState(
    val data: UserRegisterModel? = null,
    val loading: Boolean = false,
    val error: String? = EMPTY,
    val hasEmailError: Boolean? = null,
    val hasPasswordError: Boolean? = null,
    val hasPasswordMatchError: Boolean? = null,
    val isFormValid: Boolean? = null
)
