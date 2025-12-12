package com.refactoringlife.auth.features.register.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.refactoringlife.auth.features.register.presentation.content.WelcomeRegisterView
import com.refactoringlife.auth.features.register.presentation.viewmodel.RegisterViewModel

@Composable
fun WelcomeRegisterScreen(
    registerViewModel: RegisterViewModel,
    goToUserRegister: () -> Unit,
    goToFoundationRegister: () -> Unit
) {
    val state = registerViewModel.state.collectAsState().value

    WelcomeRegisterView(
        onUserRegisterClick = {
            goToUserRegister()
        },
        onFoundationRegisterClick = {
            goToFoundationRegister()
        }
    )
}