package com.refactoringlife.auth.features.login.domain.usecases

import com.refactoringlife.core.common.result.AsyncResult
import com.refactoringlife.core.data.datastore.AppPreferencesRepository

class SaveAccessTokenUseCase(
    private val appPreferencesRepository: AppPreferencesRepository
) {
    suspend operator fun invoke(token: String): AsyncResult<Boolean, Exception> {
        return try {
            appPreferencesRepository.setAccessToken(token)
            AsyncResult.Success(value = true)
        } catch (e: Exception) {
            AsyncResult.Failure(error = e)
        }
    }
}

