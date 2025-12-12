package com.refactoringlife.auth.features.onboarding.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.refactoringlife.auth.R
import com.refactoringlife.auth.features.login.presentation.theme.HuellaBackgraund

@Composable
fun OnboardingContentWithBackground(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    topIcons: List<ImageVector>? = null,
    iconSize: androidx.compose.ui.unit.Dp = 35.dp,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(HuellaBackgraund)
    ) {
        Image(
            painter = painterResource(id = R.drawable.rectangle_192),
            contentDescription = "Fondo de onda",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
        )
        OnboardingContentSection(
            title = title,
            subtitle = subtitle,
            topIcons = topIcons,
            iconSize = iconSize,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
        )
    }
}
