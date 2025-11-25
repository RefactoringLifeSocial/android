package com.refactoringlife.auth.features.forgotpassword.domain.bloc

import com.refactoringlife.auth.features.forgotpassword.domain.usecases.SendEmailResponseUseCase

class ForgotPasswordBlocs() {
    companion object {
        fun getForgotPasswordBlocs() = listOf(HandleForgotPasswordBloc(SendEmailResponseUseCase()))
    }
}
