package com.refactoringlife.core.data.datastore

class AppPreferencesRepository(
    private val serializer: AppPreferencesSerializer
) {
    suspend fun getOnboardingCompleted(): Boolean {
        return serializer.getOnboardingCompleted()
    }

    suspend fun setOnboardingCompleted(completed: Boolean) {
        serializer.setOnboardingCompleted(completed)
    }
    suspend fun getAccessToken(): String? {
        return serializer.getAccessToken()
    }

    suspend fun setAccessToken(token: String?) {
        serializer.setAccessToken(token)
    }
    suspend fun getTermsAccepted(): Boolean {
        return serializer.getTermsAccepted()
    }

    suspend fun setTermsAccepted(accepted: Boolean) {
        serializer.setTermsAccepted(accepted)
    }
}
