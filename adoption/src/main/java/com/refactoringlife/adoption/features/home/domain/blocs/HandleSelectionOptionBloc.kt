package com.refactoringlife.adoption.features.home.domain.blocs

class HandleSelectOptionBloc : InitialHomeBaseBloc {

    override fun canHandle(event: InitialHomeEvent): Boolean =
        event is InitialHomeEvent.SelectOption

    override suspend fun handle(
        event: InitialHomeEvent,
        update: InitialHomeStateUpdater
    ) {
        if (event !is InitialHomeEvent.SelectOption) return

        update { current ->
            current.copy(
                selectedOption = event.option,
                navigationDestination = null
            )
        }
    }
}
