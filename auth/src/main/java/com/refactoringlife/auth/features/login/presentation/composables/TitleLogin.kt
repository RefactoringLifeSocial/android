package com.refactoringlife.auth.features.login.presentation.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.refactoringlife.auth.R
import com.refactoringlife.auth.features.login.presentation.theme.HuellaBlue
import com.refactoringlife.auth.features.register.presentation.content.TextCustom

@Composable
fun TitleLogin(
    modifier: Modifier = Modifier
){
    TextCustom(
        title = stringResource(R.string.huella),
        fontSize = 46.sp,
        color = HuellaBlue,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center,
        modifier = modifier
            .fillMaxWidth()
    )
}
