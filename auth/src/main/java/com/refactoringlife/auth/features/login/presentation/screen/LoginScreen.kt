package com.refactoringlife.auth.features.login.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.refactoringlife.auth.features.login.domain.blocs.LoginEvent
import com.refactoringlife.auth.features.login.presentation.content.LoginView
import com.refactoringlife.auth.features.login.presentation.viewmodel.LoginViewModel

@Composable
fun LoginScreen(
    onBack: () -> Unit,
    viewModel: LoginViewModel = viewModel(),
    goToRegister: () -> Unit,
    success: () -> Unit
) {
    val state by viewModel.state.collectAsState()

    LoginView(
        onBack = {
            onBack()
        },
        onLoginClick = { email, password ->
            viewModel.sendEvent(event = LoginEvent.Login(email = email, password = password))
        },
        onForgotPassword = {

        },
        onRegisterClick = {
            goToRegister()
        }
    )
    if (state.success) {
        success()
    }
}
