package com.refactoringlife.adoption.features.home.domain.blocs

class HandleSkipBloc : InitialHomeBaseBloc {

    override fun canHandle(event: InitialHomeEvent): Boolean =
        event is InitialHomeEvent.Skip

    override suspend fun handle(
        event: InitialHomeEvent,
        update: InitialHomeStateUpdater
    ) {
        if (event !is InitialHomeEvent.Skip) return

        update { current ->
            current
        }
    }
}
