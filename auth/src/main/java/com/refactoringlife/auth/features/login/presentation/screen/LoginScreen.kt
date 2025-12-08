package com.refactoringlife.auth.features.login.presentation.screen

import android.app.Activity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.refactoringlife.auth.features.login.domain.blocs.LoginEvent
import com.refactoringlife.auth.features.login.presentation.content.LoginView
import com.refactoringlife.auth.features.login.presentation.viewmodel.LoginViewModel
import com.refactoringlife.auth.features.login.utils.GoogleUiClient
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel,
    onForgotPassword: () -> Unit,
    success: () -> Unit
) {
    val context = LocalContext.current
    val googleAuthUiClient = remember { GoogleUiClient(context) }

    val scope = rememberCoroutineScope()
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            scope.launch {
                val idToken = intent?.let { googleAuthUiClient.getSignInResultFromIntent(it) }
                loginViewModel.sendEvent(event = LoginEvent.LoginGoogle(token = idToken))
            }
        }
    }

    val state by loginViewModel.state.collectAsState()

    LoginView(
        onLoginClick = { email, password ->
            loginViewModel.sendEvent(LoginEvent.Login(email, password))
        },
        onForgotPassword = {
            onForgotPassword()

        },
        onLoginForGoogle = {
            launcher.launch(googleAuthUiClient.signInIntent())

        },
        onTermsClick = {

        },
        state = state,
        onClearState = {
            loginViewModel.sendEvent(LoginEvent.ClearState)
        }
    )
    LaunchedEffect(state.success) {
        if (state.success) {
            success()
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewLogin() {
    LoginScreen(success = {}, loginViewModel = viewModel(), onForgotPassword = {})
}