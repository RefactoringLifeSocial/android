package com.refactoringlife.adoption.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.refactoringlife.adoption.features.welcome.presentation.screen.Screen2WithNavigation
import com.refactoringlife.adoption.features.welcome.presentation.screen.Screen3WithNavigation
import com.refactoringlife.adoption.features.welcome.presentation.screen.WelcomeOnboardingScreen
import com.refactoringlife.adoption.utils.WelcomeOptions
import com.refactoringlife.core.common.extension.back
import com.refactoringlife.core.common.extension.navigateTo


@Composable
fun NavigationWrapper() {
    val backStack = rememberNavBackStack(Routes.WelcomeScreen)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.back() },
        entryProvider = entryProvider {
            entry<Routes.WelcomeScreen> {
                WelcomeOnboardingScreen(
                    selectedOption = WelcomeOptions.GALLERY,
                    onOptionSelected = { /* ... */ },
                    onAccept = {
                        // Navegar a Screen2 cuando se presiona Accept
                        backStack.navigateTo(Routes.Screen2("from_welcome"))
                    },
                    onSkip = {
                        // Navegar a Screen3 cuando se presiona Skip
                        backStack.navigateTo(Routes.Screen3)
                    }
                )
            }
            entry<Routes.Screen2> { key ->
                Screen2WithNavigation(
                    id = key.id,
                    onNavigateToScreen3 = {
                        backStack.navigateTo(Routes.Screen3)
                    },
                    onBack = {
                        backStack.back()
                    }
                )
            }
            entry<Routes.Screen3> {
                Screen3WithNavigation(
                    onBack = {
                        backStack.back()
                    }
                )
            }
        },
        transitionSpec = {
            slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(300)
            ) togetherWith slideOutHorizontally(
                targetOffsetX = { -it },
                animationSpec = tween(300)
            )
        },
        //este es para navegacion de salida
        popTransitionSpec = {
            slideInHorizontally(
                initialOffsetX = { -it },
                animationSpec = tween(300)
            ) togetherWith slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(300)
            )
        }
    )
}
