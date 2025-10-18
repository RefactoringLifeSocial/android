package com.refactoringlife.auth.features.register.domain.blocs

import com.refactoringlife.auth.features.register.presentation.state.RegisterState

typealias RegisterStateUpdate = suspend (suspend (RegisterState) -> RegisterState) -> Unit

typealias RegisterStateUpdater = suspend (suspend (RegisterState) -> RegisterState) -> Unit

interface RegisterBaseBloc {
    fun canHandle(event: RegisterEvent): Boolean
    suspend fun handle(event: RegisterEvent, update: RegisterStateUpdater)
}
