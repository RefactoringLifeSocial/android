package com.refactoringlife.auth.features.forgotpassword.domain.bloc

import com.refactoringlife.auth.features.forgotpassword.domain.state.ForgotPasswordState

class HandleForgotPasswordBloc() : ForgotPasswordBaseBloc {
    override fun canHandle(event: ForgotPasswordEvent) = event is ForgotPasswordEvent.ForgotPassword

    override suspend fun handle(
        event: ForgotPasswordEvent,
        update: suspend (suspend (ForgotPasswordState) -> ForgotPasswordState) -> Unit
    ) {
        if (event !is ForgotPasswordEvent.ForgotPassword) return

        if (event.email.isNotBlank()) {
            update {
                it.copy(showModal = true)
            }
        }
    }
}
