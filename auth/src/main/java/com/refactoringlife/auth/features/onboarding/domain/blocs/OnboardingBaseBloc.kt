package com.refactoringlife.auth.features.onboarding.domain.blocs

import com.refactoringlife.auth.features.onboarding.domain.state.OnboardingState

typealias OnboardingStateUpdater = suspend (suspend (OnboardingState) -> OnboardingState) -> Unit

interface OnboardingBaseBloc {
    fun canHandle(event: OnboardingEvent): Boolean
    suspend fun handle(event: OnboardingEvent, update: OnboardingStateUpdater)
}

