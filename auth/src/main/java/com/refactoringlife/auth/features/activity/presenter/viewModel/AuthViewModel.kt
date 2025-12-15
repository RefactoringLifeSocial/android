package com.refactoringlife.auth.features.activity.presenter.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.refactoringlife.auth.features.activity.domain.blocs.AuthBaseBloc
import com.refactoringlife.auth.features.activity.domain.blocs.AuthBlocs
import com.refactoringlife.auth.features.activity.domain.blocs.AuthEvent
import com.refactoringlife.auth.features.activity.domain.state.AuthState
import com.refactoringlife.core.data.datastore.AppPreferencesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    appPreferencesRepository: AppPreferencesRepository
) : ViewModel() {

    private val blocs: List<AuthBaseBloc> = AuthBlocs.Companion.getAuthBlocs(appPreferencesRepository)

    private val _state = MutableStateFlow(AuthState())
    val state: StateFlow<AuthState> = _state

    fun sendEvent(event: AuthEvent) {
        viewModelScope.launch {
            val bloc = blocs.firstOrNull { it.canHandle(event) } ?: return@launch
            bloc.handle(event) { reducer -> updateState(reducer) }
        }
    }

    private suspend fun updateState(reducer: suspend (AuthState) -> AuthState) {
        withContext(Dispatchers.Main) {
            val next = reducer(_state.value)
            _state.value = next
        }
    }
}