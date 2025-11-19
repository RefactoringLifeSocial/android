package com.refactoringlife.auth.features.login.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.refactoringlife.auth.features.login.domain.blocs.LoginBaseBloc
import com.refactoringlife.auth.features.login.domain.blocs.LoginEvent
import com.refactoringlife.auth.features.login.domain.state.LoginState
import com.refactoringlife.auth.features.login.domain.blocs.LoginBlocs
import com.refactoringlife.core.data.datastore.AppPreferencesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    appPreferencesRepository: AppPreferencesRepository
) : ViewModel() {

    private val blocs: List<LoginBaseBloc> = LoginBlocs.getLoginBlocs(appPreferencesRepository)

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
