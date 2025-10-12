package com.refactoringlife.auth.features.home.presentation


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.refactoringlife.auth.features.home.presentation.content.ButtonsSection
import com.refactoringlife.auth.features.home.presentation.content.FooterSection
import com.refactoringlife.auth.features.home.presentation.content.HeaderSection

@Composable
fun PreLoginView(
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
    onGoogleLoginClick: () -> Unit,
    goToSupport: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            HeaderSection()

            ButtonsSection(
                onLoginClick = onLoginClick,
                onRegisterClick = onRegisterClick,
                onGoogleLoginClick = onGoogleLoginClick
            )

            FooterSection(goToSupport = goToSupport)
        }
    }
}

fun action() {}

@Composable
@Preview
fun RunView() {
    PreLoginView(
        onLoginClick = { action() },
        onRegisterClick = { action() },
        onGoogleLoginClick = { action() },
        goToSupport = { action() }
    )
}
