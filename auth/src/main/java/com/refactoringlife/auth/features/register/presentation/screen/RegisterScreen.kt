package com.refactoringlife.auth.features.register.presentation.screen

import androidx.compose.runtime.Composable
import com.refactoringlife.auth.features.register.presentation.content.RegisterView

@Composable
fun RegisterScreen(
    onBack: () -> Unit = {},
    onClickRegister: (email: String, password: String) -> Unit
) {
    RegisterView(
        back = onBack,
        onClickRegister = onClickRegister
    )
}
