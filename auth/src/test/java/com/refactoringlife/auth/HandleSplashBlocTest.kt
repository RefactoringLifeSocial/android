package com.refactoringlife.auth

import com.refactoringlife.auth.features.splash.domain.blocs.HandleSplashBloc
import com.refactoringlife.auth.features.splash.domain.blocs.SplashEvent
import com.refactoringlife.auth.features.splash.domain.state.SplashState
import com.refactoringlife.auth.features.splash.domain.usecases.SplashTimerUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.*
import org.junit.Assert.assertTrue


@OptIn(ExperimentalCoroutinesApi::class)
class HandleSplashBlocTest {

    private val splashTimerUseCase: SplashTimerUseCase = mock()
    private val bloc = HandleSplashBloc(splashTimerUseCase)

    @Before
    fun setup() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @After
    fun teardown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `handle Start event triggers timer and sets finished state`() = runTest {
        whenever(splashTimerUseCase.invoke()).thenReturn(Unit)

        var newState: SplashState? = null

        bloc.handle(SplashEvent.Start) { reducer ->
            newState = reducer(SplashState())
        }

        verify(splashTimerUseCase).invoke()
        assertTrue(newState?.isFinished == true)
    }
}