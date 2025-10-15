package com.refactoringlife.auth.features.register.presentation.state

import com.refactoringlife.auth.features.register.domain.model.UserRegisterModel

data class RegisterState(
    val data: UserRegisterModel? = null,
    val isError : String = ""
)
