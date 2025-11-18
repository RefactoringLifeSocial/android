package com.refactoringlife.auth.features.login.presentation.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.refactoringlife.auth.R
import com.refactoringlife.auth.features.login.domain.state.LoginState
import com.refactoringlife.auth.features.login.presentation.composables.ErrorText
import com.refactoringlife.auth.features.login.presentation.composables.ImageLogo
import com.refactoringlife.auth.features.login.presentation.composables.LegalText
import com.refactoringlife.auth.features.login.presentation.composables.LoginButton
import com.refactoringlife.auth.features.login.presentation.composables.LoginGoogleButton
import com.refactoringlife.auth.features.login.presentation.composables.TextForgotPassword
import com.refactoringlife.auth.features.login.presentation.composables.TitleLogin
import com.refactoringlife.auth.features.login.presentation.composables.UnderlineTextField
import com.refactoringlife.auth.features.login.presentation.theme.HuellaBackgraund
import com.refactoringlife.auth.features.login.presentation.theme.HuellaPurple
import com.refactoringlife.core.common.ui.composables.Loading

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginView(
    onLoginClick: (email: String, password: String) -> Unit,
    onForgotPassword: () -> Unit,
    onLoginForGoogle: () -> Unit,
    onTermsClick: () -> Unit,
    state: LoginState,
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val errorMessage = when {
        state.hasEmailError -> stringResource(R.string.error_login_generic)
        state.hasPasswordError -> stringResource(R.string.error_login_generic)
        state.errorMessage?.isNotEmpty() == true -> state.errorMessage
        else -> null }

    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(HuellaBackgraund)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(horizontal = 10.dp, vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ImageLogo(modifier = Modifier.padding(top = 120.dp, bottom = 10.dp))

            TitleLogin(modifier = Modifier.padding(bottom = 30.dp))

            UnderlineTextField(
                label = stringResource(R.string.email),
                value = email,
                onValueChange = { email = it },
                isError = state.hasEmailError,
                isPassword = false,
                underlineColor = HuellaPurple,
                modifier = Modifier.padding(bottom = 20.dp)
            )

            UnderlineTextField(
                label = stringResource(R.string.password),
                value = password,
                onValueChange = { password = it },
                isError = state.hasPasswordError || state.error,
                isPassword = true,
                showErrorIcon = state.hasPasswordError || state.error,
                underlineColor = HuellaPurple,
                modifier = Modifier.padding(bottom = 4.dp)
            )

            if (errorMessage != null) {
                ErrorText(errorMessage = errorMessage)
            }

            Spacer(modifier = Modifier.height(20.dp))

            LoginButton(
                onLoginClick = { onLoginClick(email, password) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .shadow(4.dp, RoundedCornerShape(100.dp))
            )

            TextForgotPassword(
                text = stringResource(R.string.olvidaste_tu_contrase_a),
                onForgotPassword = onForgotPassword,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 16.dp)
            )

            LegalText(
                onTermsClick = onTermsClick,
                modifier = Modifier.padding(bottom = 20.dp)
            )

            LoginGoogleButton(
                userName = stringResource(R.string.usuario_xyz),
                onLoginForGoogle = onLoginForGoogle,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .shadow(6.dp, RoundedCornerShape(100.dp))
            )

            Spacer(modifier = Modifier.height(30.dp))
        }
        if (state.loading) {
            Loading()
        }
    }
}
