package com.refactoringlife.core.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.refactoringlife.core.presentation.content.CongratsView

@Composable
fun CongratsScreen(
    goToEmail: () -> Unit
) {
    CongratsView(goToEmail = { goToEmail() })
}

@Composable
@Preview(showBackground = true)
fun PreviewCongrats() {
    CongratsScreen(goToEmail = {})
}