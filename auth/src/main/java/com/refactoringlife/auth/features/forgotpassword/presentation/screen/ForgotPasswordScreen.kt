package com.refactoringlife.auth.features.forgotpassword.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import com.refactoringlife.auth.features.forgotpassword.domain.bloc.ForgotPasswordEvent
import com.refactoringlife.auth.features.forgotpassword.presentation.composables.SendEmailModal
import com.refactoringlife.auth.features.forgotpassword.presentation.content.ForgotPasswordContent
import com.refactoringlife.auth.features.forgotpassword.presentation.viewmodel.ForgotPasswordViewModel
import kotlinx.coroutines.launch

@Composable
fun ForgotPasswordScreen(
    viewModel: ForgotPasswordViewModel
) {
    val state by viewModel.uiState.collectAsState()
    val scope = rememberCoroutineScope()
    ForgotPasswordContent(
        sendEmail = {
            viewModel.sendEvent(event = ForgotPasswordEvent.ForgotPassword(email = state.email))
        },
        state = state,
        viewModel = viewModel
    )
    if (state.showModal) {
        SendEmailModal(
            onClickClose = {
                scope.launch {
                    viewModel.updateState(reducer = { state.copy(showModal = false) })
                }
            }
        )
    }
}
