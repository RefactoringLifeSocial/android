package com.refactoringlife.auth.features.forgotpassword.domain.bloc

class ForgotPasswordBlocs {
    companion object {
        fun getResetPasswordBlocs() = listOf(HandleForgotPasswordBloc())
    }
}
