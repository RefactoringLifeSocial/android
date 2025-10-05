package com.refactoringlife.core

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.refactoringlife.core.common.ui.composables.Loading
import com.refactoringlife.core.common.utils.Constants
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
            .onNodeWithTag(Constants.LOADING_ICON_TAG)
            .assertIsDisplayed()
    }

    @Test
    fun clicking_icon_triggers_action() {
        var clicked = false

        composeTestRule.setContent {
            Loading(action = { clicked = true })
        }

        composeTestRule
            .onNodeWithTag(Constants.LOADING_ICON_TAG)
            .performClick()

        assert(clicked)
    }
}