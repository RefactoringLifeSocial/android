package com.refactoringlife.adoption.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.refactoringlife.adoption.features.welcome.presentation.screen.WelcomeOnboardingScreen
import com.refactoringlife.adoption.utils.WelcomeOptions
import com.refactoringlife.core.common.extension.back

@Composable
fun NavigationWrapper() {
    val backStack = rememberNavBackStack(Routes.WelcomeScreen)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.back() },
        entryProvider = entryProvider {

            entry<Routes.WelcomeScreen> {
                WelcomeOnboardingScreen(
                    selectedOption = WelcomeOptions.FOUNDATIONS,
                    onOptionSelected = { },
                    onAccept = { },
                    onSkip = { }
                )
            }
        }
    )
}
