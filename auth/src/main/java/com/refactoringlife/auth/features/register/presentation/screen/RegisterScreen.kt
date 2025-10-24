package com.refactoringlife.auth.features.register.presentation.screen

import androidx.compose.runtime.Composable
import com.refactoringlife.auth.features.register.presentation.content.RegisterView

@Composable
fun RegisterScreen(
    registerViewModel: RegisterViewModel = viewModel(),
    onBack: () -> Unit
){
    val state by registerViewModel.state.collectAsState()

    RegisterView(
        state = state,
        onRegisterClick = { email, password, confirmPassword ->
            registerViewModel.sendEvent(RegisterEvent.UserRegister(email, password, confirmPassword))
        },
        back = {onBack()}
    )
}