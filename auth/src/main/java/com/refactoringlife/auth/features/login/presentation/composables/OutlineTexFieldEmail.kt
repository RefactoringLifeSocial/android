package com.refactoringlife.auth.features.login.presentation.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults // ¡Importar esto es crucial!
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.refactoringlife.auth.features.login.presentation.theme.GrayLight
import com.refactoringlife.auth.features.login.presentation.theme.HuellaErrorRed

@Composable
fun OutlineTextFieldEmail(
    modifier: Modifier = Modifier,

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
                fontSize = 14.sp,
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedLabelColor = GrayLight,
            focusedLabelColor = if (isError) HuellaErrorRed else Color.Unspecified,
            errorLabelColor = HuellaErrorRed,
            errorBorderColor = HuellaErrorRed,
            focusedBorderColor = if (isError) HuellaErrorRed else Color.Unspecified,
        ),
        modifier = modifier
            .fillMaxWidth()
    )
}
