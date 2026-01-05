package com.refactoringlife.adoption.features.home.domain.blocs

import com.refactoringlife.adoption.features.home.domain.state.NavigationDestination
import com.refactoringlife.adoption.navigation.Routes

class HandleSkipBloc : InitialHomeBaseBloc {

    override fun canHandle(event: InitialHomeEvent): Boolean =
        event is InitialHomeEvent.Skip

    override suspend fun handle(
        event: InitialHomeEvent,
        update: InitialHomeStateUpdater
    ) {
        if (event !is InitialHomeEvent.Skip) return
        
        update { current ->
            current.copy(
                navigationDestination = NavigationDestination.NavigateTo(Routes.GalleryScreen)
            )
        }
    }
}
