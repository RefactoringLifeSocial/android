package com.refactoringlife.auth

import androidx.compose.ui.test.*

import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.refactoringlife.auth.features.login.presentation.content.LoginView
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginViewTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun loginView_DisplaysAllTexts() {
        composeTestRule.setContent {
            LoginViewTestWrapper()
        }

        composeTestRule.onNodeWithText("Iniciar sesión").assertIsDisplayed()
        composeTestRule.onNodeWithText("Email").assertIsDisplayed()
        composeTestRule.onNodeWithText("Contraseña").assertIsDisplayed()
        composeTestRule.onNodeWithText("Entrar").assertIsDisplayed()
        composeTestRule.onNodeWithText("¿Olvidaste tu contraseña?").assertIsDisplayed()
        composeTestRule.onNodeWithText("Si no tienes cuenta,").assertIsDisplayed()
        composeTestRule.onNodeWithText("Regístrate aquí").assertIsDisplayed()
    }

    @Test
    fun loginView_LoginButtonClick_TriggersLambda() {
        var clicked = false
        composeTestRule.setContent {
            LoginView(
                onBack = {},
                onLoginClick = { _, _ -> clicked = true },
                onForgotPassword = {},
                onRegisterClick = {}
            )
        }

        composeTestRule.onNodeWithText("Entrar").performClick()
        assert(clicked)
    }

    @Test
    fun loginView_ForgotPasswordClick_TriggersLambda() {
        var clicked = false
        composeTestRule.setContent {
            LoginView(
                onBack = {},
                onLoginClick = { _, _ -> },
                onForgotPassword = { clicked = true },
                onRegisterClick = {}
            )
        }

        composeTestRule.onNodeWithText("¿Olvidaste tu contraseña?").performClick()
        assert(clicked)
    }

    @Test
    fun loginView_RegisterClick_TriggersLambda() {
        var clicked = false
        composeTestRule.setContent {
            LoginView(
                onBack = {},
                onLoginClick = { _, _ -> },
                onForgotPassword = {},
                onRegisterClick = { clicked = true }
            )
        }

        composeTestRule.onNodeWithText("Regístrate aquí").performClick()
        assert(clicked)
    }
}


@Composable
private fun LoginViewTestWrapper() {
    LoginView(
        onBack = {},
        onLoginClick = { _, _ -> },
        onForgotPassword = {},
        onRegisterClick = {}
    )
}
