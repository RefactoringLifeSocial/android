package com.refactoringlife.auth.features.register.domain.state

import com.refactoringlife.auth.features.register.domain.model.UserRegisterModel
import com.refactoringlife.auth.utils.EMPTY

data class RegisterState(
    val data: UserRegisterModel? = null,
    val loading: Boolean = false,
    val error: String? = EMPTY,
)
