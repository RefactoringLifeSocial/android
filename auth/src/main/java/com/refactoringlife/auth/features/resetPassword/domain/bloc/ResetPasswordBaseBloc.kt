package com.refactoringlife.auth.features.resetPassword.domain.bloc

import com.refactoringlife.auth.features.resetPassword.domain.state.ResetPasswordState

typealias ResetPasswordStateUpdater = suspend (suspend (ResetPasswordState) -> ResetPasswordState) -> Unit

interface ResetPasswordBaseBloc {
    fun canHandle(event: ResetPasswordEvent): Boolean
    suspend fun handle(event: ResetPasswordEvent, update: ResetPasswordStateUpdater)
}
