package com.refactoringlife.auth.features.login.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.tooling.preview.Preview
import com.refactoringlife.auth.features.login.domain.blocs.LoginEvent
import com.refactoringlife.auth.features.login.presentation.content.LoginView
import com.refactoringlife.auth.features.login.presentation.viewmodel.LoginViewModel

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = viewModel(),
    onBack: () -> Unit = {}
){
    val state by loginViewModel.state.collectAsState()

    LoginView(
        onBack = onBack,
        onLoginClick = { email, password ->
            loginViewModel.sendEvent(LoginEvent.Login(email, password))
        },
        onForgotPassword = {
            // Manejar olvidé contraseña
        },
        onRegisterClick = {
            // Manejar navegación a registro
        },
        state = state
    )
}

@Composable
@Preview(showBackground = true)
fun PreviewLogin(){
    LoginScreen()
}
