package com.refactoringlife.auth.features.login.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.refactoringlife.auth.R

@Composable
fun ImageLogo(
    modifier: Modifier = Modifier,
    image: Painter = painterResource(R.drawable.logo_huella),
    width: Dp = 116.dp,
    height: Dp = 142.dp
){
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .width(width)
            .height(height)
    )
}
