package com.refactoringlife.auth

import com.refactoringlife.auth.features.splash.domain.blocs.*
import com.refactoringlife.auth.features.splash.domain.usecases.SplashTimerUseCase
import com.refactoringlife.auth.features.splash.presentation.viewmodel.SplashViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.mockito.kotlin.verify
import org.junit.Assert.assertTrue

@OptIn(ExperimentalCoroutinesApi::class)
class SplashViewModelTest {

    private val splashTimerUseCase = mock<SplashTimerUseCase>()
    private val bloc = HandleSplashBloc(splashTimerUseCase)
    private val viewModel = SplashViewModel(listOf(bloc))

    @Before
    fun setup() {
        kotlinx.coroutines.Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @After
    fun teardown() {
        kotlinx.coroutines.Dispatchers.resetMain()
    }

    @Test
    fun `sendEvent Start triggers isFinished true`() = runTest {

        whenever(splashTimerUseCase()).thenReturn(Unit)

        viewModel.sendEvent(SplashEvent.Start)

        val state = viewModel.state.value
        assertTrue(state.isFinished)
        verify(splashTimerUseCase).invoke()
    }
}
