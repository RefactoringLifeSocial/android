package com.refactoringlife.auth.features.login.domain.usecases

import com.refactoringlife.core.common.result.AsyncResult
import com.refactoringlife.core.data.datastore.AppPreferencesRepository

class SaveTermsAcceptedUseCase(
    private val appPreferencesRepository: AppPreferencesRepository
) {
    suspend operator fun invoke(accepted: Boolean): AsyncResult<Boolean, Exception> {
        return try {
            appPreferencesRepository.setTermsAccepted(accepted)
            AsyncResult.Success(value = true)
        } catch (e: Exception) {
            AsyncResult.Failure(error = e)
        }
    }
}
