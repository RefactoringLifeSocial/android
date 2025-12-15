package com.refactoringlife.auth.features.onboarding.domain.blocs

import com.refactoringlife.auth.features.onboarding.domain.state.OnboardingState
import com.refactoringlife.auth.features.onboarding.domain.useCase.OnboardingCompleteUseCase
import com.refactoringlife.core.common.result.AsyncResult

class HandleOnboardingCompleteBloc(
    private val onboardingCompleteUseCase: OnboardingCompleteUseCase
) : OnboardingBaseBloc {

    override fun canHandle(event: OnboardingEvent): Boolean = event is OnboardingEvent.CompleteOnboarding

    override suspend fun handle(
        event: OnboardingEvent,
        update: OnboardingStateUpdater
    ) {
        if (event !is OnboardingEvent.CompleteOnboarding) return

        update { current ->
            current.copy(
                loading = true,
                error = false
            )
        }

        val result = onboardingCompleteUseCase()

        when (result) {
            is AsyncResult.Failure -> {
                update { current ->
                    current.copy(
                        error = true,
                        errorMessage = result.error.message ?: "Error al completar el onboarding",
                        loading = false
                    )
                }
            }
            is AsyncResult.Success -> {
                update { current ->
                    current.copy(
                        completed = true,
                        loading = false,
                        error = false
                    )
                }
            }
        }
    }
}

