package com.refactoringlife.auth.features.resetPassword.domain.bloc

sealed class ResetPasswordEvent {
    data class ResetPassword(
        val password : String = "",
        val confirmPassword : String = "",
        val token : String = ""
    ) : ResetPasswordEvent()
}
