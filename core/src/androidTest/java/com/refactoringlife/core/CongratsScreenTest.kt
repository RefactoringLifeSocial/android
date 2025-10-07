package com.refactoringlife.core

import androidx.compose.ui.test.assertHeightIsEqualTo
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertWidthIsEqualTo
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.unit.dp
import com.refactoringlife.core.presentation.screen.CongratsScreen
import com.refactoringlife.core.presentation.utils.Constants
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class CongratsScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun showAllContent(){
        composeTestRule.setContent {
            CongratsScreen(goToEmail = {})
        }
        composeTestRule
            .onNodeWithTag(Constants.CONGRATS_TITLE)
            .assertExists()
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithTag(Constants.CONGRATS_IMAGE)
            .assertExists()
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithTag(Constants.CONGRATS_GO_TO_EMAIL)
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun goToEmailAction(){
        var clicked = false
        composeTestRule.setContent {
            CongratsScreen(goToEmail = {clicked = true})
        }
        composeTestRule
            .onNodeWithTag(Constants.CONGRATS_GO_TO_EMAIL)
            .performClick()
        Assert.assertTrue("Error ==>> La acción goToEmail no se ejecutó al hacer click", clicked)
    }

    @Test
    fun hasCorrectDimension(){
        composeTestRule.setContent {
            CongratsScreen(goToEmail = {})
        }
        composeTestRule
            .onNodeWithTag(Constants.CONGRATS_IMAGE)
            .assertExists()
            .assertWidthIsEqualTo(100.dp)
            .assertHeightIsEqualTo(100.dp)
    }
}