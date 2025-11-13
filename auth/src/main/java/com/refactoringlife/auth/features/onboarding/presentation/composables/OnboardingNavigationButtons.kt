package com.refactoringlife.auth.features.onboarding.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.refactoringlife.auth.R
import com.refactoringlife.auth.features.login.presentation.theme.HuellaBlue
import com.refactoringlife.auth.features.login.presentation.theme.HuellaPurple

@Composable
fun OnboardingNavigationButtons(
    modifier: Modifier = Modifier,
    showNextButton: Boolean = true,
    showSkipButton: Boolean = true,
    showStartButton: Boolean = false,
    showAlreadyHaveAccount: Boolean = false,
    nextButtonIcon: Int = R.drawable.ic_next_page1,
    onNextClick: () -> Unit = {},
    onSkipClick: () -> Unit = {},
    onStartClick: () -> Unit = {},
    onAlreadyHaveAccountClick: () -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 40.dp)
    ) {
        if (showNextButton) {
            IconButton(
                onClick = onNextClick,
                modifier = Modifier
                    .size(63.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .align(Alignment.CenterHorizontally)
            ) {
                Icon(
                    painter = painterResource(nextButtonIcon),
                    contentDescription = "next button",
                    tint = HuellaBlue,
                    modifier = Modifier.size(63.dp)
                )
            }
        }

        if (showStartButton) {
            Button(
                onClick = onStartClick,
                shape = RoundedCornerShape(100.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = HuellaPurple
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 5.dp,
                ),
                modifier = modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(horizontal = 20.dp)
            ) {
                Text(
                    text = stringResource(R.string.start),
                    color = Color.White,
                    fontSize = 16.sp,
                )
            }
        }

        if (showSkipButton) {
            TextButton(
                onClick = onSkipClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp)
            ) {
                Text(
                    text = stringResource(R.string.skip),
                    fontSize = 16.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        if (showAlreadyHaveAccount) {
            TextButton(
                onClick = onAlreadyHaveAccountClick,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.already_have_account),
                    fontSize = 16.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
