package com.refactoringlife.auth.features.register.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.refactoringlife.auth.features.register.domain.blocs.RegisterEvent
import com.refactoringlife.auth.features.register.presentation.content.RegisterView
import com.refactoringlife.auth.features.register.presentation.viewmodel.RegisterViewModel

@Composable
fun RegisterScreen(
    registerViewModel: RegisterViewModel,
    onBack: () -> Unit,
    goToAdoption : () -> Unit
){
    val state = registerViewModel.state.collectAsState().value

    RegisterView(
        onClickRegister = { email, password, confirmPassword ->
            registerViewModel.sendEvent(RegisterEvent.UserRegister(email, password, confirmPassword))
        },
        back = onBack,
        state = state
    )
}