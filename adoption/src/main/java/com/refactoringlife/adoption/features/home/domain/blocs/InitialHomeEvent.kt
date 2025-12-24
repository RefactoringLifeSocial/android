package com.refactoringlife.adoption.features.home.domain.blocs

import com.refactoringlife.adoption.utils.InitialHomeOptions

sealed class InitialHomeEvent {
    data class SelectOption(val option: InitialHomeOptions) : InitialHomeEvent()
    data object Accept : InitialHomeEvent()
    data object Skip : InitialHomeEvent()
}
