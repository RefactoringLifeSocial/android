package com.refactoringlife.auth.features.login.domain.blocs

import com.refactoringlife.auth.features.login.domain.usecases.SaveAccessTokenUseCase
import com.refactoringlife.core.data.datastore.AppPreferencesRepository

class LoginBlocs {
    companion object {
        fun getLoginBlocs(
            appPreferencesRepository: AppPreferencesRepository
        ) = listOf(
            HandleLoginBloc(
                saveAccessTokenUseCase = SaveAccessTokenUseCase(
                    appPreferencesRepository = appPreferencesRepository
                )
            ),
            HandleLoginGoogleBloc(),
            HandleClearStateBloc()
        )
    }
}
