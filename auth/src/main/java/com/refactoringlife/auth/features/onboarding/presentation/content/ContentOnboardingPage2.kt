package com.refactoringlife.auth.features.onboarding.presentation.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
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
fun ContentOnboardingPage2(
    onNextClick: () -> Unit = {},
    onSkipClick: () -> Unit = {}
) {
    val scrollState = rememberScrollState()
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(HuellaBackgraund)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height((screenHeight * 0.15f).coerceAtLeast(40.dp)))

        OnboardingContentWithBackground(
            title = stringResource(R.string.title_page2),
            subtitle = stringResource(R.string.subtitle_page2),
            topIcons = listOf(Icons.Filled.Search, Icons.Filled.Add),
            modifier = Modifier.fillMaxWidth()
        )

        OnboardingNavigationButtons(
            showNextButton = true,
            showSkipButton = true,
            showStartButton = false,
            nextButtonIcon = R.drawable.ic_next_page2,
            showAlreadyHaveAccount = false,
            onNextClick = onNextClick,
            onSkipClick = onSkipClick,
            modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp)
        )
    }
}
