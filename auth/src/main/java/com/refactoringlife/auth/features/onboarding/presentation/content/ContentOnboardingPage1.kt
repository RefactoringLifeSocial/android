package com.refactoringlife.auth.features.onboarding.presentation.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.refactoringlife.auth.R
import com.refactoringlife.auth.features.login.presentation.theme.HuellaBackgraund
import com.refactoringlife.auth.features.login.presentation.theme.HuellaBlue
import com.refactoringlife.auth.features.onboarding.presentation.composables.DescriptionOnboardingPage1
import com.refactoringlife.auth.features.onboarding.presentation.composables.OnboardingImageCollage
import com.refactoringlife.auth.features.onboarding.presentation.composables.OnboardingNavigationButtons

@Composable
fun ContentOnboardingPage1(
    onNextClick: () -> Unit = {},
    onSkipClick: () -> Unit = {},
    onAlreadyHaveAccountClick: () -> Unit = {},
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(HuellaBackgraund)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.title_page1),
            color = HuellaBlue,
            fontSize = 32.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 80.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))

        Image(
            painter = painterResource(id = R.drawable.img_content_onboarding_page1),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(417.dp)
                .padding(horizontal = 10.dp)
        )

        DescriptionOnboardingPage1(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp))

        OnboardingNavigationButtons(
            showNextButton = true,
            showSkipButton = false,
            showStartButton = false,
            showAlreadyHaveAccount = true,
            onNextClick = onNextClick,
            onSkipClick = onSkipClick,
            onAlreadyHaveAccountClick = onAlreadyHaveAccountClick,
            modifier = Modifier.offset(y = (-2).dp)

        )
    }
}


@Composable
@Preview(device = "id:pixel_7_pro", showBackground = true)
fun ContentOnboardingPage1Preview() {
    ContentOnboardingPage1()
}