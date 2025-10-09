package com.refactoringlife.auth.features.login.presentation.screen

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
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

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    MaterialTheme {
        Surface {
            LoginView(
                onBack = {},
                onLoginClick = { _, _ -> },
                onForgotPassword = {},
                onRegisterClick = {}
            )
        }
    }
}
