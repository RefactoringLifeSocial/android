package com.refactoringlife.auth.features.register.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.refactoringlife.auth.features.register.presentation.content.RegisterView

@Composable
fun RegisterScreen(){
    RegisterView(back = {})
}
@Composable
@Preview(showBackground = true)
fun PreviewRegister(){
    RegisterScreen()
}