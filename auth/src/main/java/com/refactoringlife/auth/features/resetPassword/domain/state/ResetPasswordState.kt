package com.refactoringlife.auth.features.resetPassword.domain.state

data class ResetPasswordState(
    val showModal : Boolean = false,
    val password : String = "",
    val confirmPassword : String = ""
)
