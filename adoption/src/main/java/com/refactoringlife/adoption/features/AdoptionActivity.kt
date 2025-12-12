package com.refactoringlife.adoption.features

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.refactoringlife.adoption.features.welcomeOnboarding.presentation.screen.WelcomeOnboardingScreen
import com.refactoringlife.adoption.features.welcomeOnboarding.presentation.utils.WelcomeOnboardingOption

class AdoptionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WelcomeOnboardingScreen(
                selectedOption = WelcomeOnboardingOption.GALLERY,
                onOptionSelected = {},
                onAccept = {},
                onSkip = {}
            )
        }
    }
}
