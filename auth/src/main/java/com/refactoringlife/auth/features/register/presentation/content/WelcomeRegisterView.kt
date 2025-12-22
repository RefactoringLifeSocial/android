package com.refactoringlife.auth.features.register.presentation.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.refactoringlife.auth.R
import com.refactoringlife.auth.features.register.presentation.composables.WelcomeRegisterActionButton
import com.refactoringlife.auth.utils.theme.BackgroudHuella

@Composable
fun WelcomeRegisterView(
    onUserRegisterClick: () -> Unit,
    onFoundationRegisterClick: () -> Unit
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(BackgroudHuella),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroudHuella)
                .navigationBarsPadding(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth(),
                painter = painterResource(id = R.drawable.rectangle_192),
                contentDescription = "Background",
                contentScale = ContentScale.FillWidth,
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp)
            )
            {
                TitleWelcomeRegister()
                Spacer(modifier = Modifier.height(30.dp))
                WelcomeRegisterDescription()
                Spacer(modifier = Modifier.height(30.dp))
                WelcomeRegisterActionButton(
                    onUserRegisterClick = onUserRegisterClick,
                    onFoundationRegisterClick = onFoundationRegisterClick
                )
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        WelcomeRegisterDescriptionOfButtons(
            modifier = Modifier
                .padding(bottom = 30.dp)
        )
    }
}
