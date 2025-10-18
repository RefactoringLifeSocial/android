package com.refactoringlife.auth.features.register.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
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

@Composable
@Preview(showBackground = true)
fun PreviewRegister() {
    RegisterScreen(onClickRegister = handle )
}