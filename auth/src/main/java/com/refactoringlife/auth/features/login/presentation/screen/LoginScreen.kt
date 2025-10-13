package com.refactoringlife.auth.features.login.presentation.screen

import androidx.compose.runtime.Composable
import com.refactoringlife.auth.features.login.presentation.content.LoginView

@Composable
fun LoginScreen() {
    LoginView(
        onBack = {},
        onLoginClick = { _, _ -> },
        onForgotPassword = {},
        onRegisterClick = {}
    )
}
