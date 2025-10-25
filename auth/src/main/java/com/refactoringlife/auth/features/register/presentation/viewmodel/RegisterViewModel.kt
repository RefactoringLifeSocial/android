package com.refactoringlife.auth.features.register.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.refactoringlife.auth.features.register.domain.blocs.RegisterBaseBloc
import com.refactoringlife.auth.features.register.domain.blocs.RegisterBlocs
import com.refactoringlife.auth.features.register.domain.blocs.RegisterEvent
import com.refactoringlife.auth.features.register.domain.state.RegisterState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterViewModel(
    private val blocs: List<RegisterBaseBloc> = RegisterBlocs.getRegisterBlocs()
) : ViewModel() {

    private val _state = MutableStateFlow(RegisterState())
    val state: StateFlow<RegisterState> = _state

    fun sendEvent(event: RegisterEvent) {
        viewModelScope.launch {
            val bloc = blocs.firstOrNull { it.canHandle(event) } ?: return@launch
            bloc.handle(event) { reducer -> updateState(reducer) }
        }
    }

    private suspend fun updateState(reducer: suspend (RegisterState) -> RegisterState) {
        withContext(Dispatchers.Main) {
            val next = reducer(_state.value)
            _state.value = next
        }
    }
}
