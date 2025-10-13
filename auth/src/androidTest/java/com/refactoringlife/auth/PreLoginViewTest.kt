package com.refactoringlife.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.refactoringlife.auth.features.home.presentation.content.PreLoginView
import com.refactoringlife.auth.utils.TAG_GOOGLE_BUTTON
import com.refactoringlife.auth.utils.TAG_GOOGLE_ICON
import com.refactoringlife.auth.utils.TAG_GOOGLE_TEXT
import com.refactoringlife.auth.utils.TAG_LOGIN_BUTTON
import com.refactoringlife.auth.utils.TAG_LOGO
import com.refactoringlife.auth.utils.TAG_REGISTER_BUTTON
import com.refactoringlife.auth.utils.TAG_SUPPORT_TEXT
import com.refactoringlife.auth.utils.TAG_TITLE
import org.junit.Rule
import org.junit.Test

class PreLoginViewTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun displaysAllComponents() {
        composeTestRule.setContent {
            PreLoginView(
                onLoginClick = {},
                onRegisterClick = {},
                onGoogleLoginClick = {},
                goToSupport = {}
            )
        }

        composeTestRule.onNodeWithTag(TAG_LOGO).assertIsDisplayed()
        composeTestRule.onNodeWithTag(TAG_TITLE).assertIsDisplayed()
        composeTestRule.onNodeWithTag(TAG_LOGIN_BUTTON).assertIsDisplayed()
        composeTestRule.onNodeWithTag(TAG_REGISTER_BUTTON).assertIsDisplayed()
        composeTestRule.onNodeWithTag(TAG_GOOGLE_ICON).assertIsDisplayed()
        composeTestRule.onNodeWithTag(TAG_GOOGLE_TEXT).assertIsDisplayed()
        composeTestRule.onNodeWithTag(TAG_SUPPORT_TEXT).assertIsDisplayed()
        composeTestRule.onNodeWithTag(TAG_GOOGLE_BUTTON).assertIsDisplayed()
    }

    @Test
    fun loginButtonClick() {
        var loginClicked by mutableStateOf(false)

        composeTestRule.setContent {
            PreLoginView(
                onLoginClick = { loginClicked = true },
                onRegisterClick = {},
                onGoogleLoginClick = {},
                goToSupport = {}
            )
        }

        composeTestRule.onNodeWithTag(TAG_LOGIN_BUTTON).performClick()

        assert(loginClicked) {
            "Error ==>> El callback onLoginClick no fue ejecutado"
        }
    }

    @Test
    fun registerButtonClick() {
        var registerClicked by mutableStateOf(false)

        composeTestRule.setContent {
            PreLoginView(
                onLoginClick = {},
                onRegisterClick = { registerClicked = true },
                onGoogleLoginClick = {},
                goToSupport = {}
            )
        }

        composeTestRule.onNodeWithTag(TAG_REGISTER_BUTTON).performClick()

        assert(registerClicked) {
            "Error ==>> El callback onRegisterClick no fue ejecutado"
        }
    }

    @Test
    fun googleLoginClick() {
        var googleLoginClicked by mutableStateOf(false)

        composeTestRule.setContent {
            PreLoginView(
                onLoginClick = {},
                onRegisterClick = {},
                onGoogleLoginClick = { googleLoginClicked = true },
                goToSupport = {}
            )
        }

        composeTestRule.onNodeWithTag(TAG_GOOGLE_BUTTON).performClick()

        assert(googleLoginClicked) {
            "Error ==>> El callback onGoogleLoginClick no fue ejecutado"
        }
    }

    @Test
    fun supportTextClick() {
        var supportClicked by mutableStateOf(false)

        composeTestRule.setContent {
            PreLoginView(
                onLoginClick = {},
                onRegisterClick = {},
                onGoogleLoginClick = {},
                goToSupport = { supportClicked = true }
            )
        }

        composeTestRule.onNodeWithTag(TAG_SUPPORT_TEXT).performClick()

        assert(supportClicked) {
            "Error ==>> El callback goToSupport no fue ejecutado"
        }
    }

    @Test
    fun buttonsAreClickable() {
        composeTestRule.setContent {
            PreLoginView(
                onLoginClick = {},
                onRegisterClick = {},
                onGoogleLoginClick = {},
                goToSupport = {}
            )
        }

        composeTestRule.onNodeWithTag(TAG_LOGIN_BUTTON).assertHasClickAction()
        composeTestRule.onNodeWithTag(TAG_REGISTER_BUTTON).assertHasClickAction()
    }

    @Test
    fun multipleClicksOnLoginButton() {
        var clickCount by mutableStateOf(0)

        composeTestRule.setContent {
            PreLoginView(
                onLoginClick = { clickCount++ },
                onRegisterClick = {},
                onGoogleLoginClick = {},
                goToSupport = {}
            )
        }

        val loginButton = composeTestRule.onNodeWithTag(TAG_LOGIN_BUTTON)
        loginButton.performClick()
        loginButton.performClick()
        loginButton.performClick()

        assert(clickCount == 3) {
            "Error ==>> Se esperaban 3 clicks pero se registraron $clickCount"
        }
    }

    @Test
    fun allCallbacksAreIndependent() {
        var loginClicked by mutableStateOf(false)
        var registerClicked by mutableStateOf(false)
        var googleLoginClicked by mutableStateOf(false)
        var supportClicked by mutableStateOf(false)

        composeTestRule.setContent {
            PreLoginView(
                onLoginClick = { loginClicked = true },
                onRegisterClick = { registerClicked = true },
                onGoogleLoginClick = { googleLoginClicked = true },
                goToSupport = { supportClicked = true }
            )
        }

        composeTestRule.onNodeWithTag(TAG_LOGIN_BUTTON).performClick()
        assert(loginClicked && !registerClicked && !googleLoginClicked && !supportClicked) {
            "Error ==>> Solo el callback de login debería haberse ejecutado"
        }

        loginClicked = false
        composeTestRule.onNodeWithTag(TAG_REGISTER_BUTTON).performClick()
        assert(!loginClicked && registerClicked && !googleLoginClicked && !supportClicked) {
            "Error ==>> Solo el callback de register debería haberse ejecutado"
        }

        registerClicked = false
        composeTestRule.onNodeWithTag(TAG_GOOGLE_BUTTON).performClick()
        assert(!loginClicked && !registerClicked && googleLoginClicked && !supportClicked) {
            "Error ==>> Solo el callback de Google login debería haberse ejecutado"
        }

        googleLoginClicked = false
        composeTestRule.onNodeWithTag(TAG_SUPPORT_TEXT).performClick()
        assert(!loginClicked && !registerClicked && !googleLoginClicked && supportClicked) {
            "Error ==>> Solo el callback de support debería haberse ejecutado"
        }
    }
}
