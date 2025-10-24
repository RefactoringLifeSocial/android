package com.refactoringlife.auth

import com.refactoringlife.auth.features.register.domain.blocs.RegisterBaseBloc
import com.refactoringlife.auth.features.register.domain.blocs.RegisterEvent
import com.refactoringlife.auth.features.register.domain.state.RegisterState
import com.refactoringlife.auth.features.register.presentation.viewmodel.RegisterViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.*

@OptIn(ExperimentalCoroutinesApi::class)
class RegisterViewModelTest {

    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUpMainDispatcher() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDownMainDispatcher() {
        Dispatchers.resetMain()
    }

    @Test
    fun `sendEvent should call bloc handle when bloc can handle event`() = runTest {
        val mockBloc = mock<RegisterBaseBloc> {
            on { canHandle(any()) } doReturn true
        }

        val vm = RegisterViewModel(listOf(mockBloc))
        val event = mock<RegisterEvent>()

        vm.sendEvent(event)

        verify(mockBloc).handle(eq(event), any())
    }

    @Test
    fun `sendEvent should update state when bloc invokes update with reducer`() = runTest {
        val fakeBloc = object : RegisterBaseBloc {
            override fun canHandle(event: RegisterEvent): Boolean = true

            override suspend fun handle(event: RegisterEvent, update: suspend (suspend (RegisterState) -> RegisterState) -> Unit) {
                update { _old ->
                    RegisterState()
                }
            }
        }

        val vm = RegisterViewModel(listOf(fakeBloc))
        val event = mock<RegisterEvent>()

        vm.sendEvent(event)

        val resultingState = vm.state.first()

        assertEquals(RegisterState::class, resultingState::class)
    }

    @Test
    fun `sendEvent should not call handle if bloc cannot handle event`() = runTest {
        val mockBloc = mock<RegisterBaseBloc> {
            on { canHandle(any()) } doReturn false
        }
        val vm = RegisterViewModel(listOf(mockBloc))
        val event = mock<RegisterEvent>()

        vm.sendEvent(event)

        verify(mockBloc, never()).handle(any(), any())
    }
}