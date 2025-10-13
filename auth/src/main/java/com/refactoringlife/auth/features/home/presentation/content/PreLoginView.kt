package com.refactoringlife.auth.features.home.presentation.content


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.refactoringlife.auth.R
import com.refactoringlife.auth.features.home.presentation.composables.PrimaryButton
import com.refactoringlife.auth.utils.TAG_GOOGLE_ICON
import com.refactoringlife.auth.utils.TAG_GOOGLE_TEXT
import com.refactoringlife.auth.utils.TAG_LOGIN_BUTTON
import com.refactoringlife.auth.utils.TAG_LOGO
import com.refactoringlife.auth.utils.TAG_REGISTER_BUTTON
import com.refactoringlife.auth.utils.TAG_SUPPORT_TEXT
import com.refactoringlife.auth.utils.TAG_TITLE

@Composable
fun PreLoginView(
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
    onGoogleLoginClick: () -> Unit,
    goToSupport: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 60.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.refactoring_icon),
                    contentDescription = stringResource(id = R.string.refactoring_life),
                    modifier = Modifier
                        .size(150.dp)
                        .testTag(TAG_LOGO)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = stringResource(id = R.string.refactoring_life),
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    modifier = Modifier.testTag(TAG_TITLE)
                )
            }

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

                PrimaryButton(
                    text = stringResource(id = R.string.register_text),
                    onClick = onRegisterClick,
                    modifier = Modifier.testTag(TAG_REGISTER_BUTTON)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier
                        .clickable { onGoogleLoginClick() }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.login_with_google_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(120.dp)
                            .testTag(TAG_GOOGLE_ICON)
                    )

                    Text(
                        text = stringResource(id = R.string.login_with_google),
                        color = Color.Blue,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        modifier = Modifier.testTag(TAG_GOOGLE_TEXT)
                    )
                }
            }

            Text(
                text = stringResource(id = R.string.contact_support),
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier
                    .padding(bottom = 24.dp)
                    .clickable { goToSupport() }
                    .testTag(TAG_SUPPORT_TEXT)
            )
        }
    }
}
