package com.refactoringlife.auth.features.login.presentation.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.refactoringlife.auth.features.login.presentation.theme.HuellaErrorRed

@Composable
fun ErrorText(
    errorMessage: String,
    modifier: Modifier = Modifier
){
    Text(
        text = errorMessage,
        color = HuellaErrorRed,
        fontSize = 13.sp,
        textAlign = TextAlign.Center,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.Start)
            .padding(start = 20.dp)
    )
}
