package com.refactoringlife.auth.features.register.presentation.screen

import androidx.compose.runtime.Composable
import com.refactoringlife.auth.features.register.presentation.content.WelcomeRegisterView

@Composable
fun WelcomeRegisterScreen(
    goToUserRegister: () -> Unit,
    goToFoundationRegister: () -> Unit
) {

    WelcomeRegisterView(
        onUserRegisterClick = {
            goToUserRegister()
        },
        onFoundationRegisterClick = {
            goToFoundationRegister()
        }
    )
}
