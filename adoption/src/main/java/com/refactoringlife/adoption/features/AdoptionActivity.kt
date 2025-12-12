package com.refactoringlife.adoption.features

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.refactoringlife.adoption.features.welcomeAdoption.presentation.screen.AdoptionOnboardingScreen
import com.refactoringlife.adoption.features.welcomeAdoption.presentation.utils.OnboardingOption

class AdoptionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AdoptionOnboardingScreen(
                selectedOption = OnboardingOption.GALLERY,
                onOptionSelected = {},
                onAccept = {},
                onSkip = {}
            )
        }
    }
}
