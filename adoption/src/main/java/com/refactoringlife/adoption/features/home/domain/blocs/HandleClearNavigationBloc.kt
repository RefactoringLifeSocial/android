package com.refactoringlife.adoption.features.home.domain.blocs

class HandleClearNavigationBloc : InitialHomeBaseBloc {
    override fun canHandle(event: InitialHomeEvent): Boolean =
        event is InitialHomeEvent.ClearNavigation

    override suspend fun handle(
        event: InitialHomeEvent,
        update: InitialHomeStateUpdater
    ) {
        if (event !is InitialHomeEvent.ClearNavigation) return

        update { current ->
            current.copy(navigationDestination = null)
        }
    }
}
