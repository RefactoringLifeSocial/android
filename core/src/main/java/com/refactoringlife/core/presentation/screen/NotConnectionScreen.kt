package com.refactoringlife.core.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.refactoringlife.core.presentation.content.NotConnectionView

@Composable
fun NotConnectionScreen(
    onRetry: () -> Unit
) {
    NotConnectionView(onRetry = {onRetry()})
}

@Composable
@Preview(showBackground = true)
fun PreviewNotConnection() {
    NotConnectionScreen(onRetry = {})
}