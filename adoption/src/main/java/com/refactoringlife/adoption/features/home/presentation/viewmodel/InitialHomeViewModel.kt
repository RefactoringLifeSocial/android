package com.refactoringlife.adoption.features.home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.refactoringlife.adoption.features.home.domain.blocs.InitialHomeBaseBloc
import com.refactoringlife.adoption.features.home.domain.blocs.InitialHomeBlocs
import com.refactoringlife.adoption.features.home.domain.blocs.InitialHomeEvent
import com.refactoringlife.adoption.features.home.domain.state.InitialHomeState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class InitialHomeViewModel : ViewModel() {

    private val blocs: List<InitialHomeBaseBloc> = InitialHomeBlocs.getInitialHomeBlocs()

    private val _state = MutableStateFlow(InitialHomeState())
    val state: StateFlow<InitialHomeState> = _state

    fun sendEvent(event: InitialHomeEvent) {
        viewModelScope.launch {
            val bloc = blocs.firstOrNull { it.canHandle(event) } ?: return@launch
            bloc.handle(event) { reducer -> updateState(reducer) }
        }
    }

    private suspend fun updateState(reducer: suspend (InitialHomeState) -> InitialHomeState) {
        withContext(Dispatchers.Main) {
            val next = reducer(_state.value)
            _state.value = next
        }
    }
}
