package com.refactoringlife.auth.features.splash.domain.blocs

import com.refactoringlife.auth.features.splash.domain.usecases.SplashTimerUseCase

class HandleSplashBloc(
    private val splashTimerUseCase: SplashTimerUseCase = SplashTimerUseCase()
) : SplashBaseBloc {

    override fun canHandle(event: SplashEvent): Boolean = event is SplashEvent.Start

    override suspend fun handle(event: SplashEvent, update: SplashStateUpdate) {
        if (event !is SplashEvent.Start) return

        update { it.copy(startTimer = true, isFinished = false) }

        splashTimerUseCase()

        update { it.copy(startTimer = false, isFinished = true) }
    }
}