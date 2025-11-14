package com.refactoringlife.auth.features.login.presentation.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.refactoringlife.auth.features.login.presentation.theme.HuellaPurple

@Composable
fun TextForgotPassword(
    text: String,
    onForgotPassword: () -> Unit,
    modifier: Modifier = Modifier
){
    TextButton(
        onClick =  onForgotPassword,
        contentPadding = PaddingValues(0.dp),
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Text(
            text = text,
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            modifier = modifier.fillMaxWidth().wrapContentWidth(Alignment.End),
            color = HuellaPurple
        )
    }
}
