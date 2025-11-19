package com.refactoringlife.auth.features.login.domain.blocs

import com.refactoringlife.core.data.datastore.AppPreferencesRepository

class LoginBlocs {
    companion object {
        fun getLoginBlocs(
            appPreferencesRepository: AppPreferencesRepository
        ) = listOf(
            HandleLoginBloc(appPreferencesRepository = appPreferencesRepository),
            HandleLoginGoogleBloc(),
            HandleClearStateBloc()
        )
    }
}
