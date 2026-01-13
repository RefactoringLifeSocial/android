package com.refactoringlife.core.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "app_preferences")

class AppPreferencesSerializer(context: Context) {
    private val dataStore = context.dataStore

    companion object {
        private val ONBOARDING_COMPLETED_KEY = booleanPreferencesKey("onboarding_completed")
        private val ACCESS_TOKEN_KEY = stringPreferencesKey("access_token")
        private val TERMS_ACCEPTED_KEY = booleanPreferencesKey("terms_accepted")
    }

    val appPreferencesFlow: Flow<AppPreferences> = dataStore.data.map { preferences ->
        AppPreferences(
            onboardingCompleted = preferences[ONBOARDING_COMPLETED_KEY] ?: false,
            accessToken = preferences[ACCESS_TOKEN_KEY],
            termsAccepted = preferences[TERMS_ACCEPTED_KEY] ?: false
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

    suspend fun getAccessToken(): String? {
        return dataStore.data.first()[ACCESS_TOKEN_KEY]
    }

    suspend fun setAccessToken(token: String?) {
        dataStore.edit { preferences ->
            if (token != null) {
                preferences[ACCESS_TOKEN_KEY] = token
            } else {
                preferences.remove(ACCESS_TOKEN_KEY)
            }
        }
    }
    suspend fun getTermsAccepted(): Boolean {
        return appPreferencesFlow.first().termsAccepted
    }

    suspend fun setTermsAccepted(accepted: Boolean) {
        dataStore.edit { preferences ->
            preferences[TERMS_ACCEPTED_KEY] = accepted
        }
    }
}
