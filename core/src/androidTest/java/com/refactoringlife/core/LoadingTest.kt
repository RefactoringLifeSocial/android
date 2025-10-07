package com.refactoringlife.core

import androidx.compose.ui.test.assertHeightIsEqualTo
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertPositionInRootIsEqualTo
import androidx.compose.ui.test.assertWidthIsEqualTo
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.unit.dp
import com.refactoringlife.core.common.ui.composables.Loading
import com.refactoringlife.core.common.utils.Constants
import org.junit.Rule
import org.junit.Test

class LoadingTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun loading_animation_is_displayed() {
        composeTestRule.setContent {
            Loading()
        }

        composeTestRule
            .onNodeWithTag(Constants.LOADING_TAG)
            .assertIsDisplayed()
    }

    @Test
    fun loading_animation_exists_in_composition() {
        composeTestRule.setContent {
            Loading()
        }

        composeTestRule
            .onNodeWithTag(Constants.LOADING_TAG)
            .assertExists()
    }

    @Test
    fun loading_has_correct_size() {
        composeTestRule.setContent {
            Loading()
        }

        composeTestRule
            .onNodeWithTag(Constants.LOADING_TAG)
            .assertIsDisplayed()
            .assertWidthIsEqualTo(150.dp)
            .assertHeightIsEqualTo(150.dp)
    }

    @Test
    fun loading_background_is_displayed() {
        composeTestRule.setContent {
            Loading()
        }

        composeTestRule
            .onRoot()
            .assertExists()
    }

    @Test
    fun loading_is_centered() {
        composeTestRule.setContent {
            Loading()
        }

        composeTestRule
            .onNodeWithTag(Constants.LOADING_TAG)
            .assertIsDisplayed()
            .assertPositionInRootIsEqualTo(
                expectedLeft = 0.dp,
                expectedTop = 0.dp
            )
    }
}
