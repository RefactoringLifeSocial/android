package com.refactoringlife.core.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "app_preferences")

class AppPreferencesSerializer(private val context: Context) {
    private val dataStore = context.dataStore

    companion object {
        private val ONBOARDING_COMPLETED_KEY = booleanPreferencesKey("onboarding_completed")
    }

    val appPreferencesFlow: Flow<AppPreferences> = dataStore.data.map { preferences ->
        AppPreferences(
            onboardingCompleted = preferences[ONBOARDING_COMPLETED_KEY] ?: false
        )
    }

    suspend fun getOnboardingCompleted(): Boolean {
        return appPreferencesFlow.first().onboardingCompleted
    }

    suspend fun setOnboardingCompleted(completed: Boolean) {
        dataStore.edit { preferences ->
            preferences[ONBOARDING_COMPLETED_KEY] = completed
        }
    }
}
