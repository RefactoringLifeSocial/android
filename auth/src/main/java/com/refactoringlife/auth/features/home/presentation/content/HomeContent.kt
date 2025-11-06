package com.refactoringlife.auth.features.home.presentation.content


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.refactoringlife.auth.features.login.presentation.composables.ImageLogo
import com.refactoringlife.auth.features.login.presentation.composables.LoginButton
import com.refactoringlife.auth.features.login.presentation.composables.TitleLogin
import com.refactoringlife.auth.features.register.presentation.composables.RegisterButton

@Composable
fun HomeContent(
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp, end = 10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImageLogo(
            modifier = Modifier
                .padding(bottom = 10.dp)
        )

        TitleLogin(
            modifier = Modifier
                .padding(bottom = 40.dp)
        )

        LoginButton(
            onLoginClick = {
                onLoginClick()
            }
        )
        Spacer(modifier = Modifier.height(30.dp))

        RegisterButton(
            onRegisterClick = {
                onRegisterClick()
            }
        )
    }
}
