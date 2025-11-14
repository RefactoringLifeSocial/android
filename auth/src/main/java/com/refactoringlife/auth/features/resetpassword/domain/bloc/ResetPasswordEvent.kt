package com.refactoringlife.auth.features.resetpassword.domain.bloc

sealed class ResetPasswordEvent {
    data class ResetPassword(val password : String = "", val confirmPassword : String = "") : ResetPasswordEvent()
}
