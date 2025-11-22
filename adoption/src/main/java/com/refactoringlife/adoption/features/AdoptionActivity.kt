package com.refactoringlife.adoption.features

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.refactoringlife.adoption.features.presentation.WelcomeScreen

class AdoptionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WelcomeScreen(
                onUserClick = {  },
                onFoundationClick = {  }
            )
        }
    }
}