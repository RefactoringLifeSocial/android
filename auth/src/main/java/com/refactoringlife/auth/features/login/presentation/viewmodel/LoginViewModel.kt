package com.refactoringlife.auth.features.login.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.refactoringlife.auth.features.login.presentation.domain.blocs.LoginBaseBloc
import com.refactoringlife.auth.features.login.presentation.domain.blocs.LoginBlocs
import com.refactoringlife.auth.features.login.presentation.domain.blocs.LoginEvent
import com.refactoringlife.auth.features.login.presentation.domain.state.LoginState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel(
    private val blocs: List<LoginBaseBloc> = LoginBlocs.getLoginBlocs()
) : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state

    fun sendEvent(event: LoginEvent) {
        viewModelScope.launch {
            val bloc = blocs.firstOrNull { it.canHandle(event) } ?: return@launch
            bloc.handle(event) { reducer -> updateState(reducer) }
        }
    }

    private suspend fun updateState(reducer: suspend (LoginState) -> LoginState) {
        withContext(Dispatchers.Main) {
            val next = reducer(_state.value)
            _state.value = next
        }
    }
}


