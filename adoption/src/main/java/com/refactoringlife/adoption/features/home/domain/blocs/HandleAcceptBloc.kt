package com.refactoringlife.adoption.features.home.domain.blocs

class HandleAcceptBloc : InitialHomeBaseBloc {

    override fun canHandle(event: InitialHomeEvent): Boolean =
        event is InitialHomeEvent.Accept

    override suspend fun handle(
        event: InitialHomeEvent,
        update: InitialHomeStateUpdater
    ) {
        if (event !is InitialHomeEvent.Accept) return

        update { current ->
            current
        }
    }
}
