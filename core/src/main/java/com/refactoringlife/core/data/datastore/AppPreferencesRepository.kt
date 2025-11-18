package com.refactoringlife.core.data.datastore

import kotlinx.coroutines.flow.Flow

class AppPreferencesRepository(
    private val serializer: AppPreferencesSerializer
) {
    val appPreferencesFlow: Flow<AppPreferences> = serializer.appPreferencesFlow

    suspend fun getOnboardingCompleted(): Boolean {
        return serializer.getOnboardingCompleted()
    }

    suspend fun setOnboardingCompleted(completed: Boolean) {
        serializer.setOnboardingCompleted(completed)
    }
}