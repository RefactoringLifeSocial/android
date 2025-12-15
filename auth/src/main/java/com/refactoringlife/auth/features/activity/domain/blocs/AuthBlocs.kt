package com.refactoringlife.auth.features.activity.domain.blocs

import com.refactoringlife.auth.features.activity.domain.usecases.CheckInitialNavigationUseCase
import com.refactoringlife.core.data.datastore.AppPreferencesRepository

class AuthBlocs {
    companion object {
        fun getAuthBlocs(
            appPreferencesRepository: AppPreferencesRepository
        ) = listOf(
            HandleCheckInitialNavigationBloc(
                checkInitialNavigationUseCase = CheckInitialNavigationUseCase(
                    appPreferencesRepository = appPreferencesRepository
                )
            ),
            HandleDeepLinkBloc(),
            HandleClearNavigationBloc()
        )
    }
}

