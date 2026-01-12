package com.refactoringlife.auth.features.login.domain.usecases

import com.refactoringlife.core.common.result.AsyncResult
import com.refactoringlife.core.data.datastore.AppPreferencesRepository

class GetTermsAcceptedUseCase(
    private val appPreferencesRepository: AppPreferencesRepository
) {
    suspend operator fun invoke(): AsyncResult<Boolean, Exception> {
        return try {
            val accepted = appPreferencesRepository.getTermsAccepted()
            AsyncResult.Success(value = accepted)
        } catch (e: Exception) {
            AsyncResult.Failure(error = e)
        }
    }
}
