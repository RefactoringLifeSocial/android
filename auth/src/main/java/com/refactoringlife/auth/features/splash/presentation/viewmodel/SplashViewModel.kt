package com.refactoringlife.auth.features.splash.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.refactoringlife.auth.features.splash.domain.blocs.SplashBaseBloc
import com.refactoringlife.auth.features.splash.domain.blocs.SplashBlocs
import com.refactoringlife.auth.features.splash.domain.blocs.SplashEvent
import com.refactoringlife.auth.features.splash.domain.state.SplashState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashViewModel(
    private val blocs: List<SplashBaseBloc> = SplashBlocs.getSplashBlocs()
) : ViewModel() {

    private val _state = MutableStateFlow(SplashState())
    val state: StateFlow<SplashState> = _state

    fun sendEvent(event: SplashEvent) {
        viewModelScope.launch {
            val bloc = blocs.firstOrNull { it.canHandle(event) } ?: return@launch
            bloc.handle(event) { reducer -> updateState(reducer) }
        }
    }

    private suspend fun updateState(reducer: suspend (SplashState) -> SplashState) {
        withContext(Dispatchers.Main) {
            _state.value = reducer(_state.value)
        }
    }
}
