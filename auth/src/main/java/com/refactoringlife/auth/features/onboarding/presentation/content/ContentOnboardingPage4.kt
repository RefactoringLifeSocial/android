package com.refactoringlife.auth.features.onboarding.presentation.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.refactoringlife.auth.R
import com.refactoringlife.auth.features.login.presentation.theme.HuellaBackgraund
import com.refactoringlife.auth.features.onboarding.presentation.composables.OnboardingContentWithBackground
import com.refactoringlife.auth.features.onboarding.presentation.composables.OnboardingNavigationButtons

@Composable
fun ContentOnboardingPage4(
    onNextClick: () -> Unit = {},
    onSkipClick: () -> Unit = {},
    onStartClick: () -> Unit = {}
) {
    val scrollState = rememberScrollState()
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(HuellaBackgraund)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height((screenHeight * 0.15f).coerceAtLeast(40.dp)))

            OnboardingContentWithBackground(
                title = stringResource(R.string.title_page4),
                subtitle = stringResource(R.string.subtitle_page4),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(15.dp))

            OnboardingNavigationButtons(
                showNextButton = false,
                showSkipButton = false,
                showStartButton = true,
                showAlreadyHaveAccount = false,
                onNextClick = onNextClick,
                onSkipClick = onSkipClick,
                onStartClick = onStartClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp)
            )
        }
    }
}
