package com.refactoringlife.auth.features.register.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.refactoringlife.auth.features.register.presentation.content.RegisterView
import com.refactoringlife.auth.features.register.presentation.viewmodel.RegisterViewModel

@Composable
fun RegisterScreen(
    registerViewModel: RegisterViewModel,
    onBack: () -> Unit,
    goToAdoption: () -> Unit
) {
    val state = registerViewModel.state.collectAsState().value

    RegisterView(
        onClickRegister = {
            //registerViewModel.sendEvent(RegisterEvent.UserRegister())
        },
        back = onBack,
        state = state,
        viewModel = registerViewModel
    )
}