package com.refactoringlife.adoption.features.home.domain.blocs

class InitialHomeBlocs {
    companion object {
        fun getInitialHomeBlocs() = listOf(
            HandleSelectOptionBloc(),
            HandleAcceptBloc(),
            HandleSkipBloc(),
            HandleClearNavigationBloc()
        )
    }
}
