package com.refactoringlife.adoption.features.home.domain.state

import com.refactoringlife.adoption.navigation.Routes
import com.refactoringlife.adoption.utils.InitialHomeOptions

sealed class NavigationDestination {
    data class NavigateTo(val route: Routes) : NavigationDestination()
}

data class InitialHomeState(
    val selectedOption: InitialHomeOptions = InitialHomeOptions.GALLERY,
    val navigationDestination: NavigationDestination? = null
)
