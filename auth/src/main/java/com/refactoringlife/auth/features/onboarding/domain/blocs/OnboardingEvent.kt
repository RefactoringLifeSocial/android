package com.refactoringlife.auth.features.onboarding.domain.blocs

sealed class OnboardingEvent {
    object CompleteOnboarding : OnboardingEvent()
}

