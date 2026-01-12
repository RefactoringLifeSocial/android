package com.refactoringlife.core.data.datastore

data class AppPreferences(
    val onboardingCompleted: Boolean = false,
    val accessToken: String? = null,
    val termsAccepted: Boolean = false
)
