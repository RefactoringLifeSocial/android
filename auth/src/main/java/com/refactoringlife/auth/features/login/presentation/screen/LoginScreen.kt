package com.refactoringlife.auth.features.login.presentation.screen

import androidx.compose.runtime.Composable
import com.refactoringlife.auth.features.login.presentation.content.LoginView

@Composable
fun LoginScreen(
    onBack: () -> Unit = {},
    onLoginClick: (String, String) -> Unit = { _, _ -> },
    onForgotPassword: () -> Unit = {},
    onRegisterClick: () -> Unit = {}
) {
    LoginView(
        onBack = onBack,
        onLoginClick = onLoginClick,
        onForgotPassword = onForgotPassword,
        onRegisterClick = onRegisterClick
    )
}
