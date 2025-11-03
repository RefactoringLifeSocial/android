package com.refactoringlife.auth.features.forgotpassword.presentation.screen

import androidx.compose.runtime.Composable
import com.refactoringlife.auth.features.forgotpassword.presentation.content.SendEmailView

@Composable
fun ForgotPasswordScreen(
    onSendEmail: (String) -> Unit = {},
    onBack: () -> Unit = {}
) {

    SendEmailView(
        onSendEmail = { email ->
            onSendEmail(email)
        }
    )
}
