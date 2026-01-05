package com.refactoringlife.adoption.features.home.domain.blocs

import com.refactoringlife.adoption.features.home.domain.state.InitialHomeState

typealias InitialHomeStateUpdater = suspend (suspend (InitialHomeState) -> InitialHomeState) -> Unit

interface InitialHomeBaseBloc {
    fun canHandle(event: InitialHomeEvent): Boolean
    suspend fun handle(event: InitialHomeEvent, update: InitialHomeStateUpdater)
}
