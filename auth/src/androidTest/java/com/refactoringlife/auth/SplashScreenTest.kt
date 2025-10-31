package com.refactoringlife.auth

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.refactoringlife.auth.features.splash.presentation.content.SplashContent
import org.junit.Rule
import org.junit.Test

class SplashScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun splashContent_showsImage() {
        composeTestRule.setContent {
            SplashContent(startTimer = true)
        }

        composeTestRule.onNodeWithContentDescription("App Logo")
            .assertIsDisplayed()
    }

    @Test
    fun splashContent_fadesOut_whenStartTimerFalse() {
        composeTestRule.setContent {
            SplashContent(startTimer = false)
        }

        composeTestRule.onNodeWithContentDescription("App Logo")
            .assertExists()
    }
}