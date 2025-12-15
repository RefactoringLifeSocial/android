package com.refactoringlife.auth.features.activity.domain.usecases

import com.google.firebase.auth.FirebaseAuth
import com.refactoringlife.core.common.result.AsyncResult
import com.refactoringlife.core.data.datastore.AppPreferencesRepository

data class InitialNavigationResult(
    val hasUser: Boolean,
    val hasAccessToken: Boolean,
    val onboardingCompleted: Boolean
)

class CheckInitialNavigationUseCase(
    private val appPreferencesRepository: AppPreferencesRepository,
    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
) {
    suspend operator fun invoke(): AsyncResult<InitialNavigationResult, Exception> {
        return try {
            val currentUser = firebaseAuth.currentUser
            val accessToken = appPreferencesRepository.getAccessToken()
            val onboardingCompleted = appPreferencesRepository.getOnboardingCompleted()

            AsyncResult.Success(
                value = InitialNavigationResult(
                    hasUser = currentUser != null,
                    hasAccessToken = !accessToken.isNullOrEmpty(),
                    onboardingCompleted = onboardingCompleted
                )
            )
        } catch (e: Exception) {
            AsyncResult.Failure(error = e)
        }
    }
}

