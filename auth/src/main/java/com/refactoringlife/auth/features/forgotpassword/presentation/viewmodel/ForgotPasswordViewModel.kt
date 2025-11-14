package com.refactoringlife.auth.features.forgotpassword.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.refactoringlife.auth.features.forgotpassword.domain.bloc.ResetPasswordBaseBloc
import com.refactoringlife.auth.features.forgotpassword.domain.bloc.ForgotPasswordBlocs
import com.refactoringlife.auth.features.forgotpassword.domain.bloc.ForgotPasswordEvent
import com.refactoringlife.auth.features.forgotpassword.domain.state.ForgotPasswordState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ForgotPasswordViewModel(
    private val blocs: List<ResetPasswordBaseBloc> = ForgotPasswordBlocs.getResetPasswordBlocs()
) : ViewModel() {

    private val _uiState = MutableStateFlow(ForgotPasswordState())
    val uiState get() = _uiState

    fun sendEvent(event: ForgotPasswordEvent) {
        viewModelScope.launch {
            val bloc = blocs.firstOrNull() { it.canHandle(event = event) } ?: return@launch
            bloc.handle(event = event) { reducer -> updateState(reducer = reducer) }
        }
    }

    suspend fun updateState(reducer: suspend (ForgotPasswordState) -> ForgotPasswordState) {
        withContext(context = Dispatchers.Main) {
            val next = reducer(_uiState.value)
            _uiState.value = next
        }
    }
}
