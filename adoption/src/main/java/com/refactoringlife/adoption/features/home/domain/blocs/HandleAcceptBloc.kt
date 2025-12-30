package com.refactoringlife.adoption.features.home.domain.blocs

import com.refactoringlife.adoption.features.home.domain.state.NavigationDestination
import com.refactoringlife.adoption.navigation.Routes
import com.refactoringlife.adoption.utils.InitialHomeOptions

class HandleAcceptBloc : InitialHomeBaseBloc {

    override fun canHandle(event: InitialHomeEvent): Boolean =
        event is InitialHomeEvent.Accept

    override suspend fun handle(
        event: InitialHomeEvent,
        update: InitialHomeStateUpdater
    ) {
        if (event !is InitialHomeEvent.Accept) return

        update { current ->
            val destination = when (current.selectedOption) {
                InitialHomeOptions.GALLERY -> NavigationDestination.NavigateTo(Routes.GalleryScreen)
                InitialHomeOptions.FOUNDATIONS -> NavigationDestination.NavigateTo(Routes.FoundationsScreen)
                InitialHomeOptions.REPORT -> NavigationDestination.NavigateTo(Routes.ReportScreen)
            }

            current.copy(
                navigationDestination = destination
            )
        }
    }
}
