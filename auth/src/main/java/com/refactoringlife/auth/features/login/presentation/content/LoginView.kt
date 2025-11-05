package com.refactoringlife.auth.features.login.presentation.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.refactoringlife.auth.R
import com.refactoringlife.auth.features.login.domain.state.LoginState
import com.refactoringlife.auth.features.login.presentation.composables.ImageLogo
import com.refactoringlife.auth.features.login.presentation.composables.LoginButton
import com.refactoringlife.auth.features.login.presentation.composables.LoginForGoogleButton
import com.refactoringlife.auth.features.login.presentation.composables.OutlineTextFieldEmail
import com.refactoringlife.auth.features.login.presentation.composables.OutlineTextFieldPassword
import com.refactoringlife.auth.features.login.presentation.composables.TextForgotPassword
import com.refactoringlife.auth.features.login.presentation.composables.TitleLogin
import com.refactoringlife.auth.features.login.presentation.theme.DividerColor
import com.refactoringlife.auth.features.login.presentation.theme.HuellaBackgraund
import com.refactoringlife.auth.features.login.presentation.theme.HuellaErrorRed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginView(
    onLoginClick: (email: String, password: String) -> Unit,
    onForgotPassword: () -> Unit,
    onLoginForGoogle: () -> Unit,
    state: LoginState,
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val errorMessage = when {
        state.hasEmailError -> stringResource(R.string.error_login_generic)
        state.hasPasswordError -> stringResource(R.string.error_login_generic)
        state.errorMessage?.isNotEmpty() == true -> state.errorMessage
        else -> null
    }
    val scrollState = rememberScrollState()

    Box(modifier = Modifier
        .fillMaxSize()
        .background(HuellaBackgraund)) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.TopCenter)
                .padding(horizontal = 10.dp, vertical = 10.dp)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ImageLogo(modifier = Modifier.padding(top = 70.dp, bottom = 10.dp))

            TitleLogin(modifier = Modifier.padding(bottom = 30.dp))

            OutlineTextFieldEmail(
                text = stringResource(R.string.username),
                label = stringResource(R.string.username),
                value = email,
                onValueChange = { email = it },
                isError = state.hasEmailError,
                modifier = Modifier.padding(bottom = 30.dp)
            )

            OutlineTextFieldPassword(
                text = stringResource(R.string.password),
                label = stringResource(R.string.password),
                value = password,
                onValueChange = { password = (it) },
                isError = state.hasPasswordError,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            if (errorMessage != null) {
                Text(
                    text = errorMessage,
                    color = HuellaErrorRed,
                    fontSize = 13.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.Start)
                        .padding(start = 20.dp)
                )
            }
            Spacer(modifier = Modifier.height(30.dp))

            LoginButton(
                onLoginClick = {
                    onLoginClick(email, password)
                }
            )

            TextForgotPassword(
                text = stringResource(R.string.forgot_your_password),
                onForgotPassword = {
                    onForgotPassword()
                }
            )

            HorizontalDivider(color = DividerColor, thickness = 1.dp)
            Spacer(modifier = Modifier.height(30.dp))

            LoginForGoogleButton(
                onLoginForGoogle = {
                    onLoginForGoogle()
                }
            )
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewLogin() {
    LoginView(
        onLoginClick = { _, _ -> },
        onForgotPassword = {},
        onLoginForGoogle = {},
        state = LoginState()
    )
}
