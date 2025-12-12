package com.refactoringlife.adoption.features.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.refactoringlife.adoption.R


@Composable
fun AdoptionOnboardingScreen(
    onUserClick: () -> Unit,
    onFoundationClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.wavebackground),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(0.65f),
            contentScale = ContentScale.FillBounds
        )

        Row(
            modifier = Modifier.padding(top = 40.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            WelcomeButton(
                textResId = R.drawable.soyusuario,
                textWidth = 95.dp,
                textHeight = 58.dp,
                onClick = onUserClick
            )

            WelcomeButton(
                textResId = R.drawable.soyfundacion,
                textWidth = 130.dp,
                textHeight = 58.dp,
                onClick = onFoundationClick
            )
        }
    }
}
