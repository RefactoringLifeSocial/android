package com.refactoringlife.auth.features.register.domain.blocs

import com.refactoringlife.auth.features.login.domain.state.LoginState
import com.refactoringlife.auth.features.register.domain.state.RegisterState

typealias RegisterStateUpdater = suspend (suspend (RegisterState) -> RegisterState) -> Unit

interface RegisterBaseBloc {
    fun canHandle(event: RegisterEvent): Boolean
    suspend fun handle(event: RegisterEvent, update: RegisterStateUpdater)
}
