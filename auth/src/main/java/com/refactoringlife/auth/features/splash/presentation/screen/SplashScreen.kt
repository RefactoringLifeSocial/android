package com.refactoringlife.auth.features.splash.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.refactoringlife.auth.features.splash.presentation.content.SplashContent
import com.refactoringlife.auth.features.splash.presentation.viewmodel.SplashViewModel

@Composable
fun SplashScreen(
    splashViewModel: SplashViewModel,
    onFinish: () -> Unit
) {
    val state by splashViewModel.state.collectAsState()

    SplashContent(startTimer = state.startTimer)

    if (state.isFinished) {
        onFinish()
    }
}