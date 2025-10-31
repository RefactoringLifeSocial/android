package com.refactoringlife.auth.features.splash.presentation.content

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.refactoringlife.auth.R

@Composable
fun SplashContent(startTimer: Boolean) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        val alpha by animateFloatAsState(
            targetValue = if (startTimer) 1f else 0f,
            animationSpec = tween(durationMillis = 1000)
        )

        Image(
            painter = painterResource(id = R.drawable.splash_icon),
            contentDescription = "App Logo",
            modifier = Modifier
                .graphicsLayer(alpha = alpha)
                .size(150.dp)
        )
    }
}