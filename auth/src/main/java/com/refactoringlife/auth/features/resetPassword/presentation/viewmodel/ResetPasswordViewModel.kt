package com.refactoringlife.auth.features.resetPassword.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.refactoringlife.auth.features.resetPassword.domain.bloc.ResetPasswordBaseBloc
import com.refactoringlife.auth.features.resetPassword.domain.bloc.ResetPasswordBlocs
import com.refactoringlife.auth.features.resetPassword.domain.bloc.ResetPasswordEvent
import com.refactoringlife.auth.features.resetPassword.domain.state.ResetPasswordState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ResetPasswordViewModel(
    private val blocs: List<ResetPasswordBaseBloc> = ResetPasswordBlocs.Companion.getResetPasswordBlocs()
) : ViewModel() {

    private val _uiState = MutableStateFlow(ResetPasswordState())
    val uiState get() = _uiState

    fun sendEvent(event: ResetPasswordEvent) {
        viewModelScope.launch {
            val bloc = blocs.firstOrNull() { it.canHandle(event = event) } ?: return@launch
            bloc.handle(event = event) { reducer -> updateState(reducer = reducer) }
        }
    }

    suspend fun updateState(reducer: suspend (ResetPasswordState) -> ResetPasswordState) {
        viewModelScope.launch {
            val next = reducer(_uiState.value)
            _uiState.value = next
        }
    }
}
