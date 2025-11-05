package com.refactoringlife.auth.features.login.presentation.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.refactoringlife.auth.features.login.presentation.theme.GrayLight
import com.refactoringlife.auth.features.login.presentation.theme.HuellaErrorRed

@Composable
fun OutlineTextFieldPassword(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    isError: Boolean,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            isError = isError,
            label = {
                Text(
                    text = label,
                    fontSize = 14.sp,
                )
            },
            placeholder = {
                Text(
                    text = text,
                    fontSize = 16.sp,
                    color = GrayLight
                )
            },
            trailingIcon = {
                if (isError) {
                    Icon(
                        imageVector = Icons.Filled.Warning,
                        contentDescription = "Error",
                        tint = HuellaErrorRed
                    )
                }
            },
            visualTransformation = PasswordVisualTransformation(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = if (isError) HuellaErrorRed else Color.Unspecified,
                unfocusedTextColor = if (isError) HuellaErrorRed else Color.Unspecified,
                errorTextColor = HuellaErrorRed,
                focusedBorderColor = if (isError) HuellaErrorRed else Color.Unspecified,
                unfocusedBorderColor = if (isError) HuellaErrorRed else Color.Unspecified,
                errorBorderColor = HuellaErrorRed,
                errorLabelColor = HuellaErrorRed,
                cursorColor = if (isError) HuellaErrorRed else Color.Unspecified
            ),
            modifier = modifier
                .fillMaxWidth()
                .height(56.dp)
        )
    }
}
