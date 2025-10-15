package com.refactoringlife.auth.features.login.domain.state

import com.refactoringlife.auth.features.login.domain.model.UserLoginModel

data class LoginState(
    val loading: Boolean = false,
    val errorMessage : String? = "",
    val data : UserLoginModel? = null
)