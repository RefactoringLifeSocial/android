package com.refactoringlife.auth.features.activity.domain.blocs

import com.refactoringlife.auth.features.activity.domain.state.NavigationDestination
import com.refactoringlife.auth.features.resetPassword.fragment.ResetPasswordFragment
import com.refactoringlife.core.common.utils.DeepLinkRouter

class HandleDeepLinkBloc : AuthBaseBloc {

    override fun canHandle(event: AuthEvent): Boolean = event is AuthEvent.HandleDeepLink

    override suspend fun handle(
        event: AuthEvent,
        update: AuthStateUpdater
    ) {
        if (event !is AuthEvent.HandleDeepLink) return

        val uri = event.uri ?: return

        val deepLinkResult = DeepLinkRouter.parseDeepLink(uri)

        val destination: NavigationDestination? = when (deepLinkResult) {
            is DeepLinkRouter.DeepLinkResult.ResetPassword -> {
                NavigationDestination.NavigateToRoot(
                    ResetPasswordFragment.createInstance(deepLinkResult.token)
                )
            }
            is DeepLinkRouter.DeepLinkResult.Unknown -> null
        }

        if (destination != null) {
            update { current ->
                current.copy(
                    navigationDestination = destination,
                    error = false
                )
            }
        }
    }
}

