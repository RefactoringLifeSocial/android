package com.refactoringlife.auth.features.forgotpassword.domain.bloc

import com.refactoringlife.auth.features.forgotpassword.domain.state.ForgotPasswordState

class HandleForgotPasswordBloc() : ResetPasswordBaseBloc {
    override fun canHandle(event: ForgotPasswordEvent) = event is ForgotPasswordEvent.ResetPassword

    override suspend fun handle(
        event: ForgotPasswordEvent,
        update: suspend (suspend (ForgotPasswordState) -> ForgotPasswordState) -> Unit
    ) {
        if (event !is ForgotPasswordEvent.ResetPassword) return

        if (event.email.isNotBlank()) {
            update {
                it.copy(showModal = true)
            }
        }
    }
}
