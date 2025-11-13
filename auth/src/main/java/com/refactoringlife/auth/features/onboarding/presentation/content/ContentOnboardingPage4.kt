package com.refactoringlife.auth.features.onboarding.presentation.content

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.refactoringlife.auth.R
import com.refactoringlife.auth.features.onboarding.presentation.composables.BackGroundColorOnboarding
import com.refactoringlife.auth.features.onboarding.presentation.composables.OnboardingContentSection
import com.refactoringlife.auth.features.onboarding.presentation.composables.OnboardingNavigationButtons

@Composable
fun ContentOnboardingPage4(
    onNextClick: () -> Unit = {},
    onSkipClick: () -> Unit = {},
    onStartClick: () -> Unit = {}
) {
    BackGroundColorOnboarding(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            OnboardingContentSection(
                title = stringResource(R.string.title_page4),
                subtitle = stringResource(R.string.subtitle_page4),
                modifier = Modifier.align(Alignment.Center)
            )
            OnboardingNavigationButtons(
                showNextButton = false,
                showSkipButton = false,
                showStartButton = true,
                showAlreadyHaveAccount = false,
                onNextClick = onNextClick,
                onSkipClick = onSkipClick,
                onStartClick = onStartClick,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 30.dp)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ContentOnboardingPage4Preview() {
    ContentOnboardingPage4()
}
