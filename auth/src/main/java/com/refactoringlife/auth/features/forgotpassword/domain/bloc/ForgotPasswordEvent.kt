package com.refactoringlife.auth.features.forgotpassword.domain.bloc

sealed class ForgotPasswordEvent {
    data class ResetPassword(val email : String) : ForgotPasswordEvent()
}
