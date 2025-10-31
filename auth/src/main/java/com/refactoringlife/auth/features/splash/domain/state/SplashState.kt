package com.refactoringlife.auth.features.splash.domain.state

data class SplashState(
    val startTimer: Boolean = true,
    val isFinished: Boolean = false
)
