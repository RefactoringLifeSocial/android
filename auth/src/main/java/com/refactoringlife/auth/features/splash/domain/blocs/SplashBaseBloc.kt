package com.refactoringlife.auth.features.splash.domain.blocs

import com.refactoringlife.auth.features.splash.domain.state.SplashState

typealias SplashStateUpdate = suspend (suspend (SplashState) -> SplashState) -> Unit

interface SplashBaseBloc {
    fun canHandle(event: SplashEvent): Boolean
    suspend fun handle(event: SplashEvent, update: SplashStateUpdate)
}
