package com.refactoringlife.auth.features.register.presentation.content

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.refactoringlife.auth.R
import com.refactoringlife.auth.features.register.domain.state.RegisterState
import com.refactoringlife.auth.features.register.presentation.theme.backgroundRegister
import com.refactoringlife.auth.features.register.presentation.theme.grayLight
import com.refactoringlife.auth.features.register.presentation.viewmodel.RegisterViewModel
import kotlinx.coroutines.launch

typealias email = String
typealias password = String
typealias confirmPassword = String

@Composable
fun RegisterView(
    back: () -> Unit,
    onClickRegister: () -> Unit,
    viewModel: RegisterViewModel,
    state: RegisterState
) {
    val scope = rememberCoroutineScope()
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
                value = state.name,
                onValueChange = { newValue ->
                    scope.launch {
                        viewModel.updateState(reducer = { state.copy(name = newValue) })
                    }
                },
                modifier = Modifier,
                placeholderText = stringResource(id = R.string.register_name),
                placeholderFontSize = 16.sp,
                placeHolderColor = grayLight,
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextFieldCustom(
                value = state.country,
                onValueChange = { newValue ->
                    scope.launch {
                        viewModel.updateState(reducer = { state.copy(country = newValue) })
                    }
                },
                placeholderText = stringResource(id = R.string.register_Country),
                placeholderFontSize = 16.sp,
                placeHolderColor = grayLight,
                modifier = Modifier
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextFieldCustom(
                value = state.address,
                onValueChange = { newValue ->
                    scope.launch {
                        viewModel.updateState(reducer = { state.copy(address = newValue) })
                    }
                },
                placeholderText = stringResource(id = R.string.register_addres),
                placeholderFontSize = 16.sp,
                placeHolderColor = grayLight,
                modifier = Modifier
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextFieldCustom(
                value = state.phone,
                onValueChange = { newValue ->
                    scope.launch {
                        viewModel.updateState(reducer = { state.copy(phone = newValue) })
                    }
                },
                placeholderText = stringResource(id = R.string.register_phone),
                placeholderFontSize = 16.sp,
                placeHolderColor = grayLight,
                modifier = Modifier,
                keyboardType = KeyboardType.Number,
                onlyNumbers = true
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextFieldCustom(
                value = state.email,
                onValueChange = { newValue ->
                    scope.launch {
                        viewModel.updateState(reducer = { state.copy(email = newValue) })
                    }
                },
                placeholderText = stringResource(id = R.string.register_email),
                placeholderFontSize = 16.sp,
                placeHolderColor = grayLight,
                modifier = Modifier
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextFieldCustom(
                value = state.password,
                onValueChange = { newValue ->
                    scope.launch {
                        viewModel.updateState(reducer = { state.copy(password = newValue) })
                    }
                },
                placeholderText = stringResource(id = R.string.register_password),
                placeholderFontSize = 16.sp,
                placeHolderColor = grayLight,
                modifier = Modifier
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextFieldCustom(
                value = state.confirmPassword,
                onValueChange = { newValue ->
                    scope.launch {
                        viewModel.updateState(reducer = { state.copy(confirmPassword = newValue) })
                    }
                },
                placeholderText = stringResource(id = R.string.register_password),
                placeholderFontSize = 16.sp,
                placeHolderColor = grayLight,
                modifier = Modifier
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
                    onClickRegister()
                },
                text = stringResource(id = R.string.register_button_next),
                backgroundColor = backgroundRegister,
                textFontSize = 16.5.sp,
                textFontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(50.dp))
        },
        state = state,
        viewModel = viewModel
    )
}
