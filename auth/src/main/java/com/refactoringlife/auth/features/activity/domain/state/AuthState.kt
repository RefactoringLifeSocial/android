package com.refactoringlife.auth.features.activity.domain.state

import androidx.fragment.app.Fragment

sealed class NavigationDestination {
    data class NavigateToRoot(val fragment: Fragment) : NavigationDestination()
    data class NavigateTo(val fragment: Fragment) : NavigationDestination()
    data class NavigateToDeeplink(val deeplink: String) : NavigationDestination()
    object Finish : NavigationDestination()
    object GoBack : NavigationDestination()
}

data class AuthState(
    val navigationDestination: NavigationDestination? = null,
    val loading: Boolean = false,
    val error: Boolean = false,
    val errorMessage: String? = null
)

