package com.refactoringlife.adoption.features

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.refactoringlife.adoption.features.welcome.presentation.screen.WelcomeOnboardingScreen
import com.refactoringlife.adoption.utils.WelcomeOptions

class AdoptionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WelcomeOnboardingScreen(
                selectedOption = WelcomeOptions.GALLERY,
                onOptionSelected = {},
                onAccept = {},
                onSkip = {}
            )
        }
    }
}
