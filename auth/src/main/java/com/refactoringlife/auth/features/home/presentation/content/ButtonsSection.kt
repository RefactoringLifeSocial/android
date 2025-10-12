package com.refactoringlife.auth.features.home.presentation.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.refactoringlife.auth.R
import com.refactoringlife.auth.features.home.presentation.composables.PrimaryButton
import com.refactoringlife.auth.utils.TAG_GOOGLE_ICON
import com.refactoringlife.auth.utils.TAG_LOGIN_BUTTON
import com.refactoringlife.auth.utils.TAG_REGISTER_BUTTON

@Composable
fun ButtonsSection(
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
    onGoogleLoginClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {

        PrimaryButton(
            text = stringResource(id = R.string.sign_in_text),
            onClick = onLoginClick,
            modifier = Modifier.testTag(TAG_LOGIN_BUTTON)
        )

        Spacer(modifier = Modifier.height(5.dp))

        PrimaryButton(
            text = stringResource(id = R.string.register_text),
            onClick = onRegisterClick,
            modifier = Modifier.testTag(TAG_REGISTER_BUTTON)
        )

        Spacer(modifier = Modifier.height(8.dp))

        GoogleLoginSection(
            onClick = onGoogleLoginClick
        )
    }
}