package com.refactoringlife.auth.features.onboarding.domain.useCase

import com.refactoringlife.core.common.result.AsyncResult
import com.refactoringlife.core.data.datastore.AppPreferencesRepository

class OnboardingCompleteUseCase(
    private val appPreferencesRepository: AppPreferencesRepository
) {
    suspend operator fun invoke(): AsyncResult<Boolean, Exception> {
        return try {
            appPreferencesRepository.setOnboardingCompleted(true)
            AsyncResult.Success(value = true)
        } catch (e: Exception) {
            AsyncResult.Failure(error = e)
        }
    }
}