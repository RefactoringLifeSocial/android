package com.refactoringlife.adoption.features.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.refactoringlife.adoption.R


@Composable
fun WelcomeButton(
    textResId: Int,
    textWidth: Dp,
    textHeight: Dp,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(width = 167.dp, height = 153.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) { onClick() }
            .semantics { contentDescription = "user_button"},
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.welcomebutton),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Image(
            painter = painterResource(id = textResId),
            contentDescription = null,
            modifier = Modifier
                .size(textWidth, textHeight),
            contentScale = ContentScale.Fit
        )
    }
}
