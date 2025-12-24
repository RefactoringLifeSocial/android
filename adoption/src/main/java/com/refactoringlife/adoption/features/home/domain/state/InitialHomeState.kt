package com.refactoringlife.adoption.features.home.domain.state

import com.refactoringlife.adoption.utils.InitialHomeOptions

data class InitialHomeState(
    val selectedOption : InitialHomeOptions = InitialHomeOptions.GALLERY
)
