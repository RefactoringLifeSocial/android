package com.refactoringlife.auth.features.activity.domain.blocs

import com.refactoringlife.auth.features.activity.domain.state.AuthState

typealias AuthStateUpdater = suspend (suspend (AuthState) -> AuthState) -> Unit

interface AuthBaseBloc {
    fun canHandle(event: AuthEvent): Boolean
    suspend fun handle(event: AuthEvent, update: AuthStateUpdater)
}

