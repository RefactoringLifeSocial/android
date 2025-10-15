package com.refactoringlife.auth.features.login.presentation.screen

import androidx.compose.runtime.Composable
import com.refactoringlife.auth.features.login.presentation.content.LoginView

@Composable
fun LoginScreen(
    onLoginClick: (email : String, password : String) -> Unit,
) {
    LoginView(
        onBack = {},
        onLoginClick = { email, password ->
            onLoginClick(email,password)
        },
        onForgotPassword = {},
        onRegisterClick = {}
    )
}
