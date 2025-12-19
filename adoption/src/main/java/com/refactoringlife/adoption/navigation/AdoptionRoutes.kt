package com.refactoringlife.adoption.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable
@Serializable
sealed class Routes: NavKey {
    @Serializable
    data object WelcomeScreen : Routes()

    @Serializable
    data class Screen2 (val id: String) : Routes()

    @Serializable
    data object Screen3 : Routes()
}
