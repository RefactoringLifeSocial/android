package com.refactoringlife.auth.features.forgotpassword.domain.bloc

sealed class ForgotPasswordEvent {
    data class ForgotPassword(val email : String) : ForgotPasswordEvent()
}
