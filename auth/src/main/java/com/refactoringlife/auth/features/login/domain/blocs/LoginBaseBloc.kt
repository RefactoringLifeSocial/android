package com.refactoringlife.auth.features.login.domain.blocs

import com.refactoringlife.auth.features.login.domain.state.LoginState

typealias LoginStateUpdater = suspend (suspend (LoginState) -> LoginState) -> Unit

interface LoginBaseBloc {
    fun canHandle(event: LoginEvent): Boolean
    suspend fun handle(event: LoginEvent, update: LoginStateUpdater)
}