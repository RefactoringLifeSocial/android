package com.refactoringlife.core.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.refactoringlife.core.presentation.content.ErrorView

@Composable
fun ErrorScreen() {
    ErrorView()
}

@Composable
@Preview(showBackground = true)
fun PreviewError() {
    ErrorScreen()
}