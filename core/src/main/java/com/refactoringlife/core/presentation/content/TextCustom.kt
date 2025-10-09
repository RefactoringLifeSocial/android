package com.refactoringlife.core.presentation.content

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit

@Composable
fun TextCustom(
    title: String,
    modifier: Modifier,
    fontSize: TextUnit,
    color: androidx.compose.ui.graphics.Color,
    fontWeight: FontWeight,
    textAlign: TextAlign
) {
    Text(
        text = title,
        textAlign = textAlign,
        fontSize = fontSize,
        fontWeight = fontWeight,
        color = color,
        modifier = modifier
    )
}