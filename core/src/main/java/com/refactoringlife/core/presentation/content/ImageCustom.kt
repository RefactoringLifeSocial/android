package com.refactoringlife.core.presentation.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp

@Composable
fun ImageCustom(
    imageResId: Int,
    contentDescription: String,
    width: Dp,
    height: Dp,
    modifier: Modifier
){
    Image(
        painter = painterResource(id = imageResId),
        contentDescription = contentDescription,
        modifier = modifier.size(width,height)
    )
}