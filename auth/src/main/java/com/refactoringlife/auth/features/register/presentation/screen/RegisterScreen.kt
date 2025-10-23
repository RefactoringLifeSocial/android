package com.refactoringlife.auth.features.register.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.tooling.preview.Preview
import com.refactoringlife.auth.features.register.domain.blocs.RegisterEvent
import com.refactoringlife.auth.features.register.presentation.content.RegisterView
import com.refactoringlife.auth.features.register.presentation.viewmodel.RegisterViewModel

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

@Composable
@Preview(showBackground = true)
fun PreviewRegister(){
    RegisterScreen(onBack = {})
}
