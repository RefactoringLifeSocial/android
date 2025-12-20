package com.refactoringlife.adoption.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable
@Serializable
sealed class Routes: NavKey {
    @Serializable
    data object WelcomeScreen : Routes()
}
