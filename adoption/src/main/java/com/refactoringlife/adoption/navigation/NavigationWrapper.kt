package com.refactoringlife.adoption.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.refactoringlife.adoption.features.home.domain.blocs.InitialHomeEvent
import com.refactoringlife.adoption.features.home.domain.state.NavigationDestination
import com.refactoringlife.adoption.features.home.presentation.screen.FoundationScreen
import com.refactoringlife.adoption.features.home.presentation.screen.GalleryScreen
import com.refactoringlife.adoption.features.home.presentation.screen.InitialHomeSelectionScreen
import com.refactoringlife.adoption.features.home.presentation.screen.ReportScreen
import com.refactoringlife.adoption.features.home.presentation.viewmodel.InitialHomeViewModel
import com.refactoringlife.core.common.extension.back
import com.refactoringlife.core.common.extension.navigateTo

@Composable
fun NavigationWrapper() {
    val backStack = rememberNavBackStack(Routes.WelcomeScreen)
    val initialHomeViewModel = remember { InitialHomeViewModel() }

    val state by initialHomeViewModel.state.collectAsState()

    LaunchedEffect(state.navigationDestination) {
        state.navigationDestination?.let { destination ->
            when (destination) {
                is NavigationDestination.NavigateTo -> {
                    backStack.navigateTo(destination.route)
                    initialHomeViewModel.sendEvent(InitialHomeEvent.ClearNavigation)
                }
            }
        }
    }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.back() },
        entryProvider = entryProvider {
            entry<Routes.WelcomeScreen> {
                InitialHomeSelectionScreen(
                    viewModel = initialHomeViewModel
                )
            }
            entry<Routes.GalleryScreen> {
                GalleryScreen()
            }
            entry<Routes.FoundationsScreen> {
                FoundationScreen()
            }
            entry<Routes.ReportScreen> {
                ReportScreen()
            }
        }
    )
}
