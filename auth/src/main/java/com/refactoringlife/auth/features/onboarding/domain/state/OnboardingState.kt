package com.refactoringlife.auth.features.onboarding.domain.state

data class OnboardingState(
    val completed: Boolean = false,
    val loading: Boolean = false,
    val error: Boolean = false,
    val errorMessage: String? = null
)

