package com.refactoringlife.adoption.features

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.refactoringlife.adoption.features.welcomeAdoption.presentation.screen.WelcomeAdoptionScreen
import com.refactoringlife.adoption.features.welcomeAdoption.presentation.utils.WelcomeOption

class AdoptionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
//            WelcomeScreen(
//                onUserClick = {  },
//                onFoundationClick = {  }
//            )
            WelcomeAdoptionScreen(
                selectedOption = WelcomeOption.GALLERY,
                onOptionSelected = {

                },
                onAccept = {

                },
                onSkip = {

                }
            )
        }
    }
}
