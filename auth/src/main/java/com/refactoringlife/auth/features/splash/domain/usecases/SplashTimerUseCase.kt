package com.refactoringlife.auth.features.splash.domain.usecases

import kotlinx.coroutines.delay

class SplashTimerUseCase {
    suspend operator fun invoke() {
        delay(2000L)
    }
}