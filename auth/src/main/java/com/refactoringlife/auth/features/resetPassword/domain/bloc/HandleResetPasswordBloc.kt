package com.refactoringlife.auth.features.resetPassword.domain.bloc

import com.refactoringlife.auth.features.resetPassword.domain.state.ResetPasswordState

class HandleResetPasswordBloc : ResetPasswordBaseBloc {
    override fun canHandle(event: ResetPasswordEvent) = event is ResetPasswordEvent.ResetPassword

    override suspend fun handle(
        event: ResetPasswordEvent,
        update: suspend (suspend (ResetPasswordState) -> ResetPasswordState) -> Unit
    ) {
        if (event !is ResetPasswordEvent.ResetPassword) return

        if (event.password.isNotBlank() && event.confirmPassword.isNotBlank()){
            update{
                it.copy(
                    showModal = true
                )
            }
        }
    }
}
