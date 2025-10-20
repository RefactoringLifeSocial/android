package com.refactoringlife.auth.features.register.presentation.content

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import com.refactoringlife.auth.R
import com.refactoringlife.auth.features.register.presentation.state.RegisterState
import com.refactoringlife.auth.features.register.presentation.theme.grayLight
import com.refactoringlife.auth.features.register.presentation.theme.purpleLight

@Composable
fun RegisterView(
    state: RegisterState,
    onRegisterClick: (String, String, String) -> Unit = { _, _, _ -> },
    back: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    var showConfirmPassword by remember { mutableStateOf(false) }

    val errorMessage = when {
        state.hasEmailError -> stringResource(R.string.error_email_invalid)
        state.hasPasswordError -> stringResource(R.string.error_password_invalid)
        state.hasPasswordMatchError -> stringResource(R.string.error_password_mismatch)
        state.isError.isNotEmpty() -> state.isError
        else -> null
    }

    BaseRegister(
        back = {
            back()
        },
        centerContent = {
            // Email field
            TextFieldCustom(
                value = email,
                onValueChange = { value ->
                    email = value
                },
                modifier = Modifier,
                placeholderText = stringResource(id = R.string.register_email),
                placeholderFontSize = 16.sp,
                icon = R.drawable.user,
                iconWidth = 25.dp,
                iconHeight = 25.dp,
                placeHolderColor = grayLight
            )

            Spacer(modifier = Modifier.height(50.dp))

            // Password field
            TextFieldCustom(
                value = password,
                onValueChange = { value ->
                    password = value
                },
                modifier = Modifier,
                placeholderText = stringResource(id = R.string.register_password),
                placeholderFontSize = 16.sp,
                placeHolderColor = grayLight,
                icon = R.drawable.locked,
                iconWidth = 25.dp,
                iconHeight = 25.dp,
                isPassword = true,
                showPassword = showPassword
            )

            // Checkbox para mostrar/ocultar password
            ShowPassword(
                checked = showPassword,
                onCheckedChange = { showPassword = it },
                text = stringResource(id = R.string.register_show_password),
                textFontSize = 14.sp,
                textFontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(2.dp))

            // Confirm Password field
            TextFieldCustom(
                value = confirmPassword,
                onValueChange = { value ->
                    confirmPassword = value
                },
                modifier = Modifier,
                placeholderText = stringResource(id = R.string.register_repeat_password),
                placeholderFontSize = 16.sp,
                placeHolderColor = grayLight,
                icon = R.drawable.locked,
                iconWidth = 25.dp,
                iconHeight = 25.dp,
                isPassword = true,
                showPassword = showConfirmPassword
            )

            ShowPassword(
                checked = showConfirmPassword,
                onCheckedChange = { showConfirmPassword = it },
                text = stringResource(id = R.string.register_show_password),
                textFontSize = 14.sp,
                textFontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(50.dp))

            if (errorMessage != null) {
                TextCustom(
                    title = errorMessage,
                    fontSize = 14.sp,
                    color = Color.Red,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 42.dp, vertical = 8.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))

            ButtonCustom(
                onClick = { onRegisterClick(email, password, confirmPassword) },
                text = stringResource(id = R.string.register_button_),
                backgroundColor = purpleLight,
                textFontSize = 15.sp,
                textFontWeight = FontWeight.SemiBold
            )
        },
        bottomContent = {
            TextCustom(
                title = stringResource(id = R.string.register_communication_message),
                fontSize = 15.sp,
                color = grayLight,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 42.dp)
            )
        }
    )
}

@Composable
@Preview
fun PreviewRegisterView(){
    RegisterView(
        state = RegisterState()
    ) {  }
}