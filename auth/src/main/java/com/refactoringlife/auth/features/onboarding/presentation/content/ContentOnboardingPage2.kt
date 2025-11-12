package com.refactoringlife.auth.features.onboarding.presentation.content

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
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
fun ContentOnboardingPage2(
    onNextClick: () -> Unit = {},
    onSkipClick: () -> Unit = {}
) {
    BackGroundColorOnboarding(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            OnboardingContentSection(
                title = stringResource(R.string.title_page2),
                subtitle = stringResource(R.string.subtitle_page2),
                topIcons = listOf(Icons.Filled.Search, Icons.Filled.Add),
                modifier = Modifier.align(Alignment.Center)
            )
            OnboardingNavigationButtons(
                showNextButton = true,
                showSkipButton = true,
                showStartButton = false,
                nextButtonIcon = R.drawable.ic_next_page2,
                showAlreadyHaveAccount = false,
                onNextClick = onNextClick,
                onSkipClick = onSkipClick,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 40.dp)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ContentOnboardingPage2Preview() {
    ContentOnboardingPage2()
}
