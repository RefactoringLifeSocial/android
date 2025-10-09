package com.refactoringlife.auth.features.login.presentation.content

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldLogin(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholderText: String,
    placeholderFontSize: TextUnit,
    icon: Int,
    iconHeight: Dp,
    iconWidth: Dp,
    placeHolderColor: Color = Color.Gray,
    showPassword: Boolean = false
) {
    val isPreview = LocalInspectionMode.current

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        visualTransformation = if (isPreview) VisualTransformation.None
        else if (showPassword) VisualTransformation.None
        else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        leadingIcon = {
            if (isPreview) {
                Icon(
                    imageVector = if (icon == android.R.drawable.ic_lock_lock) Icons.Default.Lock else Icons.Default.Info,
                    contentDescription = null,
                    modifier = Modifier.size(width = iconWidth, height = iconHeight),
                    tint = Color.Black
                )
            } else {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    modifier = Modifier.size(width = iconWidth, height = iconHeight),
                    tint = Color.Black
                )
            }
        },
        placeholder = {
            Text(
                text = placeholderText,
                fontSize = placeholderFontSize,
                color = placeHolderColor
            )
        },
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth()
            .padding(horizontal = 0.dp)
            .background(Color.White, RectangleShape)
            .border(1.dp, Color.Black.copy(alpha = 0.3f), RectangleShape)
    )
}