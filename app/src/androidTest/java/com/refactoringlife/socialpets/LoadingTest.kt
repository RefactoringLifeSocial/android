package com.refactoringlife.socialpets

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import com.refactoringlife.socialpets.ui.composables.Loading
import org.junit.Rule
import org.junit.Test
class LoadingTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun loading_icon_is_displayed() {
        composeTestRule.setContent {
            Loading(action = {})
        }

        composeTestRule
            .onNodeWithContentDescription("Icono de carga")
            .assertIsDisplayed()
    }

    @Test
    fun clicking_icon_triggers_action() {
        var clicked = false

        composeTestRule.setContent {
            Loading(action = { clicked = true })
        }

        composeTestRule
            .onNodeWithContentDescription("Icono de carga")
            .performClick()

        assert(clicked)
    }
}