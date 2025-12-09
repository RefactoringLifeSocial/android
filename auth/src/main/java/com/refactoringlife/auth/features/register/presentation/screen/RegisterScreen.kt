package com.refactoringlife.auth.features.register.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.refactoringlife.auth.features.register.domain.blocs.RegisterEvent
import com.refactoringlife.auth.features.register.domain.state.RegisterState
import com.refactoringlife.auth.features.register.presentation.content.RegisterView
import com.refactoringlife.auth.features.register.presentation.viewmodel.RegisterViewModel
import com.refactoringlife.core.common.ui.composables.Loading

@Composable
fun RegisterScreen(
    registerViewModel: RegisterViewModel,
    onBack: () -> Unit,
    success: () -> Unit

) {
    val state = registerViewModel.state.collectAsState().value

    RegisterView(
        onClickRegister = {
            registerViewModel.sendEvent(
                RegisterEvent.UserRegister(
                    email = state.email,
                    password = state.password,
                    confirmPassword = state.confirmPassword,
                    name = state.name,
                    country = state.country,
                    address = state.address,
                    phone = state.phone
                )
            )
        },
        back = onBack,
        state = state,
        viewModel = registerViewModel
    )
    if (state.loading){
        Loading()
    }
    LaunchedEffect(state.success) {
        if (state.success) {
            registerViewModel.updateState { RegisterState() }
            success()
        }
    }
}
