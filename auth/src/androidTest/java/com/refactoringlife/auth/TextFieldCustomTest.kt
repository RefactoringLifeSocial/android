package com.refactoringlife.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.refactoringlife.auth.features.register.presentation.content.TextFieldCustom
import com.refactoringlife.auth.features.register.presentation.util.Constants
import org.junit.Rule
import org.junit.Test

class TextFieldCustomTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun showPlaceHolder() {
        val placeholderText = "Contraseña"

        composeTestRule.setContent {
            TextFieldCustom(
                value = "",
                onValueChange = { },
                placeholderText = placeholderText,
                placeholderFontSize = 16.sp,
                placeHolderColor = Color.Gray,
                icon = R.drawable.locked,
                iconWidth = 25.dp,
                iconHeight = 25.dp,
                modifier = Modifier.testTag(Constants.TEXT_FIELD_REGISTER)
            )
        }
        composeTestRule.onNodeWithText(placeholderText)
            .assertIsDisplayed()
        composeTestRule.onNodeWithTag(Constants.TEXT_FIELD_REGISTER)
            .assertIsDisplayed()
    }

    @Test
    fun onValueChange() {
        var textState by mutableStateOf("")
        val textToWrite = "testinput"

        composeTestRule.setContent {
            TextFieldCustom(
                value = textState,
                onValueChange = { newValue ->
                    textState = newValue
                },
                placeholderText = "Contraseña",
                placeholderFontSize = 16.sp,
                placeHolderColor = Color.Gray,
                icon = R.drawable.locked,
                iconWidth = 25.dp,
                iconHeight = 25.dp,
                modifier = Modifier.testTag(Constants.TEXT_FIELD_REGISTER)
            )
        }

        composeTestRule.onNodeWithTag(Constants.TEXT_FIELD_REGISTER)
            .performTextInput(textToWrite)

        assert(textState == textToWrite) {
            "Error ==>> El callback onValueChange no actualizó textState"
        }
        composeTestRule.onNodeWithText(textToWrite)
            .assertExists()
            .assertIsDisplayed()
    }
}