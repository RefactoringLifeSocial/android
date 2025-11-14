package com.refactoringlife.auth.features.forgotpassword.domain.bloc

class ForgotPasswordBlocs {
    companion object {
        fun getForgotPasswordBlocs() = listOf(HandleForgotPasswordBloc())
    }
}
