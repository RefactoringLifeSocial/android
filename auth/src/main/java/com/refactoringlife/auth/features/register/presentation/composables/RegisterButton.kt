package com.refactoringlife.auth.features.register.presentation.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.refactoringlife.auth.R
import com.refactoringlife.auth.features.login.presentation.theme.HuellaPurple

@Composable
fun RegisterButton(
    onRegisterClick: () -> Unit,
    modifier: Modifier = Modifier,
){
    OutlinedButton (
        onClick = onRegisterClick,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .border(
                width = 5.dp,
                color = HuellaPurple,
                shape = RoundedCornerShape(100.dp)
            )
    ) {
        Text(
            text = stringResource(R.string.register_button_),
            color = HuellaPurple,
            fontSize = 16.sp,
        )
    }
}
