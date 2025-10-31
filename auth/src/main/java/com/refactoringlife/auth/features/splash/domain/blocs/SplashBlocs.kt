package com.refactoringlife.auth.features.splash.domain.blocs

class SplashBlocs {
    companion object {
        fun getSplashBlocs() = listOf(
            HandleSplashBloc()
        )
    }
}