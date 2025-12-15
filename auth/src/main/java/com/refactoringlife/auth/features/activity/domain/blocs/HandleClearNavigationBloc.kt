package com.refactoringlife.auth.features.activity.domain.blocs

class HandleClearNavigationBloc : AuthBaseBloc {

    override fun canHandle(event: AuthEvent): Boolean = event is AuthEvent.ClearNavigation

    override suspend fun handle(
        event: AuthEvent,
        update: AuthStateUpdater
    ) {
        if (event !is AuthEvent.ClearNavigation) return

        update { current ->
            current.copy(
                navigationDestination = null
            )
        }
    }
}

