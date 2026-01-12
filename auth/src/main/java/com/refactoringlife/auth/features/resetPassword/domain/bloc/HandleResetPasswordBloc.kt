package com.refactoringlife.auth.features.resetPassword.domain.bloc

import com.refactoringlife.auth.features.resetPassword.domain.state.ResetPasswordState
import com.refactoringlife.core.common.utils.isPasswordMatch
import com.refactoringlife.core.common.utils.isValidPassword

class HandleResetPasswordBloc : ResetPasswordBaseBloc {
    override fun canHandle(event: ResetPasswordEvent) = event is ResetPasswordEvent.ResetPassword

    override suspend fun handle(
        event: ResetPasswordEvent,
        update: suspend (suspend (ResetPasswordState) -> ResetPasswordState) -> Unit
    ) {
        if (event !is ResetPasswordEvent.ResetPassword) return

        if (event.password.isValidPassword() && event.confirmPassword.isValidPassword() && event.password.isPasswordMatch(event.confirmPassword)) {
            update {
                it.copy(
                    showModal = true, hasPasswordError = false
                )
            }
        } else {
            update {
                it.copy(
                    showModal = false, hasPasswordError = true
                )
            }
        }
    }
}
