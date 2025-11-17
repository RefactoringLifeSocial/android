package com.refactoringlife.auth.features.resetpassword.domain.state

data class ResetPasswordState(
    val showModal : Boolean = false,
    val password : String = "",
    val confirmPassword : String = ""
)
