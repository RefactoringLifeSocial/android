package com.refactoringlife.auth.features.login.presentation.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.refactoringlife.auth.features.login.presentation.theme.GrayLight

@Composable
fun OutlineTextFieldEmail(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    isError: Boolean,
){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        isError = isError,
        label = {
            Text(
                text = label,
                fontSize = 14.sp
            )
        },
        placeholder = {
            Text(
                text = text,
                fontSize = 16.sp,
                color = GrayLight
            )
        },
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
    )
}
