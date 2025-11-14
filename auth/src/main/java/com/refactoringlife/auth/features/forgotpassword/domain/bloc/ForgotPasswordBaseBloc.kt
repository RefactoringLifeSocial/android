package com.refactoringlife.auth.features.forgotpassword.domain.bloc

import com.refactoringlife.auth.features.forgotpassword.domain.state.ForgotPasswordState

typealias ForgotPasswordStateUpdater = suspend (suspend (ForgotPasswordState) -> ForgotPasswordState) -> Unit

interface ForgotPasswordBaseBloc {
    fun canHandle(event: ForgotPasswordEvent): Boolean
    suspend fun handle(event: ForgotPasswordEvent, update: ForgotPasswordStateUpdater)
}
