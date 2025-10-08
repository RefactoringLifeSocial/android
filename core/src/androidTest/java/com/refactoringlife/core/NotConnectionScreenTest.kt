package com.refactoringlife.core

import androidx.compose.ui.test.assertHeightIsEqualTo
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertWidthIsEqualTo
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.unit.dp
import com.refactoringlife.core.presentation.screen.NotConnectionScreen
import com.refactoringlife.core.presentation.utils.Constants
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class NotConnectionScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun showAllContent(){
        composeTestRule.setContent {
            NotConnectionScreen(onRetry = {})
        }
        composeTestRule
            .onNodeWithTag(Constants.NOT_CONNECTION_TITLE)
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithTag(Constants.NOT_CONNECTION_RETRY)
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithTag(Constants.NOT_CONNECTION_IMAGE)
            .assertIsDisplayed()
    }

    @Test
    fun retryAction(){
        var clicked = false
        composeTestRule.setContent {
            NotConnectionScreen(onRetry = {clicked = true})
        }
        composeTestRule
            .onNodeWithTag(Constants.NOT_CONNECTION_RETRY)
            .performClick()

        Assert.assertTrue("Error ==>> La acción onRetry no se ejecutó al hacer click", clicked)
    }

    @Test
    fun retryActionMultipleClick(){
        val clickTarget = 20
        var clickCount = 0

        composeTestRule.setContent {
            NotConnectionScreen(onRetry = {clickCount++})
        }
        val retry = composeTestRule.onNodeWithTag(Constants.NOT_CONNECTION_RETRY)
        repeat(clickTarget){
            retry.performClick()
        }
        Assert.assertEquals("ERROR ==>> El contador de clics no coincide con la cantidad esperada ($clickTarget).",clickTarget,clickCount)
    }

    @Test
    fun hasCorrectDimension(){
        composeTestRule.setContent {
            NotConnectionScreen(onRetry = {})
        }
        composeTestRule
            .onNodeWithTag(Constants.NOT_CONNECTION_IMAGE)
            .assertExists()
            .assertWidthIsEqualTo(220.dp)
            .assertHeightIsEqualTo(220.dp)
    }
}