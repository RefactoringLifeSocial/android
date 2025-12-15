package com.refactoringlife.auth.features.activity.domain.blocs

import com.refactoringlife.auth.features.activity.domain.state.NavigationDestination
import com.refactoringlife.auth.features.activity.domain.usecases.CheckInitialNavigationUseCase
import com.refactoringlife.auth.features.home.presentation.fragment.HomeFragment
import com.refactoringlife.auth.features.onboarding.presentation.fragment.OnboardingPage1Fragment
import com.refactoringlife.core.common.result.AsyncResult
import com.refactoringlife.core.common.utils.ADOPTION_DEEPLINK

class HandleCheckInitialNavigationBloc(
    private val checkInitialNavigationUseCase: CheckInitialNavigationUseCase
) : AuthBaseBloc {

    override fun canHandle(event: AuthEvent): Boolean = event is AuthEvent.CheckInitialNavigation

    override suspend fun handle(
        event: AuthEvent,
        update: AuthStateUpdater
    ) {
        if (event !is AuthEvent.CheckInitialNavigation) return

        update { current ->
            current.copy(
                loading = true,
                error = false
            )
        }

        val result = checkInitialNavigationUseCase()

        when (result) {
            is AsyncResult.Failure -> {
                update { current ->
                    current.copy(
                        error = true,
                        errorMessage = result.error.message ?: "Error al verificar navegación inicial",
                        loading = false
                    )
                }
            }
            is AsyncResult.Success -> {
                val navigationResult = result.value
                val destination: NavigationDestination = when {
                    navigationResult.hasUser || navigationResult.hasAccessToken -> {
                        NavigationDestination.NavigateToDeeplink(ADOPTION_DEEPLINK)
                    }
                    navigationResult.onboardingCompleted -> {
                        NavigationDestination.NavigateToRoot(HomeFragment.createInstance("id"))
                    }
                    else -> {
                        NavigationDestination.NavigateToRoot(OnboardingPage1Fragment.createInstance())
                    }
                }

                update { current ->
                    current.copy(
                        navigationDestination = destination,
                        loading = false,
                        error = false
                    )
                }
            }
        }
    }
}

