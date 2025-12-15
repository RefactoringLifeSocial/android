package com.refactoringlife.auth.features.onboarding.domain.blocs

import com.refactoringlife.auth.features.onboarding.domain.useCase.OnboardingCompleteUseCase
import com.refactoringlife.core.data.datastore.AppPreferencesRepository

class OnboardingBlocs {
    companion object {
        fun getOnboardingBlocs(
            appPreferencesRepository: AppPreferencesRepository
        ) = listOf(
            HandleOnboardingCompleteBloc(
                onboardingCompleteUseCase = OnboardingCompleteUseCase(
                    appPreferencesRepository = appPreferencesRepository
                )
            )
        )
    }
}

