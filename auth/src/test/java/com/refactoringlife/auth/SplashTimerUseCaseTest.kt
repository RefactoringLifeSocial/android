package com.refactoringlife.auth

import com.refactoringlife.auth.features.splash.domain.usecases.SplashTimerUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class SplashTimerUseCaseTest {

    private val useCase = SplashTimerUseCase()

    @Test
    fun `invoke completes without errors`() = runTest {
        useCase()
    }
}
