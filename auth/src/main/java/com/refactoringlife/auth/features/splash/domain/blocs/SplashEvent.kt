package com.refactoringlife.auth.features.splash.domain.blocs

sealed class SplashEvent {
    data object Start : SplashEvent()
}
