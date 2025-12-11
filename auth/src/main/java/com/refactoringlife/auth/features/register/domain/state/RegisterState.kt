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
    val isFormValid: Boolean = false,
    val success: Boolean = false,
    val name : String = "",
    val country : String = "",
    val address : String = "",
    val phone : String = "",
    val email : String = "",
    val password : String = "",
    val confirmPassword : String = "",
    val image : String = ""
)
