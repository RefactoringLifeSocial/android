package com.refactoringlife.auth.features.resetPassword.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import com.refactoringlife.auth.features.resetPassword.domain.bloc.ResetPasswordEvent
import com.refactoringlife.auth.features.resetPassword.presentation.composables.ResetModal
import com.refactoringlife.auth.features.resetPassword.presentation.content.ResetPasswordContent
import com.refactoringlife.auth.features.resetPassword.presentation.viewmodel.ResetPasswordViewModel
import kotlinx.coroutines.launch

@Composable
fun ResetPasswordScreen(
    viewModel: ResetPasswordViewModel,
    token: String
) {
    val scope = rememberCoroutineScope()
    val state by viewModel.uiState.collectAsState()
    ResetPasswordContent(
        state = state,
        sendPassword = {
            viewModel.sendEvent(
                event = ResetPasswordEvent.ResetPassword(
                    password = state.password,
                    confirmPassword = state.confirmPassword,
                    token = token
                )
            )
        },
        viewModel = viewModel
    )
    if (state.showModal) {
        ResetModal(
            onClickClose = {
                scope.launch {
                    viewModel.updateState(reducer = { state.copy(showModal = false) })
                }
            }
        )
    }
}
