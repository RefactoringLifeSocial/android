package com.refactoringlife.adoption.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.refactoringlife.adoption.features.home.presentation.screen.InitialHomeSelectionScreen
import com.refactoringlife.adoption.features.home.presentation.viewmodel.InitialHomeViewModel
import com.refactoringlife.adoption.utils.InitialHomeOptions
import com.refactoringlife.core.common.extension.back

@Composable
fun NavigationWrapper() {
    val backStack = rememberNavBackStack(Routes.WelcomeScreen)
    val initialHomeViewModel = remember { InitialHomeViewModel() }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.back() },
        entryProvider = entryProvider {

            entry<Routes.WelcomeScreen> {
                InitialHomeSelectionScreen(
                   viewModel =  initialHomeViewModel
                )
            }
        }
    )
}
