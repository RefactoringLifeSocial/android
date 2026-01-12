package com.refactoringlife.auth.features.forgotpassword.domain.state

data class ForgotPasswordState(
    val showModal : Boolean = false,
    val email : String = "",
    val hasEmailError: Boolean = false
)
