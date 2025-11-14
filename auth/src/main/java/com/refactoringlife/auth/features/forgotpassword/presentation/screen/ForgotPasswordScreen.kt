@file:JvmName("ForgotPasswordScreenKt")

package com.refactoringlife.auth.features.forgotpassword.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import com.refactoringlife.auth.features.forgotpassword.domain.bloc.ForgotPasswordEvent
import com.refactoringlife.auth.features.forgotpassword.presentation.composables.SendEmailModal
import com.refactoringlife.auth.features.forgotpassword.presentation.content.ResetPasswordContent
import com.refactoringlife.auth.features.forgotpassword.presentation.viewmodel.ForgotPasswordViewModel
import kotlinx.coroutines.launch

@Composable
fun ForgotPasswordScreen(
    viewModel: ForgotPasswordViewModel
) {
    val state by viewModel.uiState.collectAsState()
    val scope = rememberCoroutineScope()
    ResetPasswordContent(
        sendEmail = {
            viewModel.sendEvent(event = ForgotPasswordEvent.ResetPassword(email = state.email))
        },
        emailValue = { email ->
            scope.launch {
                viewModel.updateState(reducer = { state.copy(email = email) })
            }
        },
        state = state
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
