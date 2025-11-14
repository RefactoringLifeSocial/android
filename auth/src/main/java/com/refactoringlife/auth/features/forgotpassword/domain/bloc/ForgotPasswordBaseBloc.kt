package com.refactoringlife.auth.features.forgotpassword.domain.bloc

import com.refactoringlife.auth.features.forgotpassword.domain.state.ForgotPasswordState

typealias ResetPasswordStateUpdater = suspend (suspend (ForgotPasswordState) -> ForgotPasswordState) -> Unit

interface ResetPasswordBaseBloc {
    fun canHandle(event: ForgotPasswordEvent): Boolean
    suspend fun handle(event: ForgotPasswordEvent, update: ResetPasswordStateUpdater)
}
