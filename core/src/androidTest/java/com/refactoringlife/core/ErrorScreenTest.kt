package com.refactoringlife.core

import androidx.compose.ui.test.assertHeightIsEqualTo
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertWidthIsEqualTo
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.unit.dp
import com.refactoringlife.core.presentation.screen.ErrorScreen
import com.refactoringlife.core.presentation.utils.Constants
import org.junit.Rule
import org.junit.Test

class ErrorScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun showAllContent(){
        composeTestRule.setContent {
            ErrorScreen()
        }
        composeTestRule
            .onNodeWithTag(Constants.ERROR_TITLE)
            .assertExists()
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithTag(Constants.ERROR_COMMUNICATION)
            .assertExists()
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithTag(Constants.ERROR_IMAGE)
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun hasCorrectDimension(){
        composeTestRule.setContent {
            ErrorScreen()
        }
        composeTestRule
            .onNodeWithTag(Constants.ERROR_IMAGE)
            .assertExists()
            .assertWidthIsEqualTo(100.dp)
            .assertHeightIsEqualTo(100.dp)
    }
}