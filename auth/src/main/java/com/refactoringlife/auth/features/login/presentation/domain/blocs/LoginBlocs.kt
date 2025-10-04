package com.refactoringlife.auth.features.login.presentation.domain.blocs

class LoginBlocs {
    companion object{
        fun getLoginBlocs() = listOf(HandleLoginBloc())
    }
}