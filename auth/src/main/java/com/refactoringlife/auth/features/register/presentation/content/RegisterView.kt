package com.refactoringlife.auth.features.register.presentation.content

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.refactoringlife.auth.R
import com.refactoringlife.auth.features.register.domain.state.RegisterState
import com.refactoringlife.auth.features.register.presentation.theme.backgroundRegister
import com.refactoringlife.auth.features.register.presentation.theme.grayLight
import com.refactoringlife.core.common.utils.Constants.EMPTY

typealias email = String
typealias password = String
typealias confirmPassword = String

@Composable
fun RegisterView(
    back: () -> Unit,
    onClickRegister: (email, password, confirmPassword) -> Unit,
    state: RegisterState
) {
    var email by remember { mutableStateOf(EMPTY) }
    var password by remember { mutableStateOf(EMPTY) }
    var confirmPassword by remember { mutableStateOf(EMPTY) }
    var showPassword by remember { mutableStateOf(false) }
    var showConfirmPassword by remember { mutableStateOf(false) }
    val errorMessage = when {
        state.hasEmailError -> stringResource(R.string.error_email_invalid)
        state.hasPasswordError -> stringResource(R.string.error_password_invalid)
        state.hasPasswordMatchError -> stringResource(R.string.error_password_mismatch)
        state.error?.isNotEmpty() == true -> state.error
        else -> null
    }
    BaseRegister(
        back = {
            back.invoke()
        },
        centerContent = {
            TextFieldCustom(
                value = email,
                onValueChange = { newValue ->
                    email = newValue
                },
                modifier = Modifier,
                placeholderText = stringResource(id = R.string.register_name),
                placeholderFontSize = 16.sp,
                placeHolderColor = grayLight,

                )
            Spacer(modifier = Modifier.height(16.dp))
            TextFieldCustom(
                value = password,
                onValueChange = { newValue ->
                    password = newValue
                },
                placeholderText = stringResource(id = R.string.register_Country),
                placeholderFontSize = 16.sp,
                placeHolderColor = grayLight,
                modifier = Modifier,
                isPassword = true,
                showPassword = showPassword
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextFieldCustom(
                value = confirmPassword,
                onValueChange = { newValue ->
                    confirmPassword = newValue
                },
                placeholderText = stringResource(id = R.string.register_addres),
                placeholderFontSize = 16.sp,
                placeHolderColor = grayLight,
                modifier = Modifier,
                isPassword = true,
                showPassword = showConfirmPassword
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextFieldCustom(
                value = "",
                onValueChange = { newValue ->

                },
                placeholderText = stringResource(id = R.string.register_phone),
                placeholderFontSize = 16.sp,
                placeHolderColor = grayLight,
                modifier = Modifier,
                isPassword = true,
                showPassword = showConfirmPassword
            )
            Spacer(modifier = Modifier.height(30.dp))
            if (errorMessage != null) {
                Text(
                    text = errorMessage,
                    color = Red,
                    fontSize = 13.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 40.dp),
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            ButtonCustom(
                onClick = {
                    onClickRegister(email, password, confirmPassword)
                },
                text = stringResource(id = R.string.register_button_next),
                backgroundColor = backgroundRegister,
                textFontSize = 16.5.sp,
                textFontWeight = FontWeight.SemiBold
            )
        }
    )
}
