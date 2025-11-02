package com.refactoringlife.auth.features.forgotpassword.presentation.screen

import androidx.compose.runtime.Composable
import com.refactoringlife.auth.features.forgotpassword.presentation.content.SendEmailView
import com.refactoringlife.auth.features.forgotpassword.presentation.content.VerifyCodeView

@Composable
fun ForgotPasswordScreen(
    onSendEmail: (String) -> Unit = {},
    onBack: () -> Unit = {}
) {
    VerifyCodeView()
//    SendEmailView(
//        onSendEmail = { email ->
//            onSendEmail(email)
//        }
//    )
}