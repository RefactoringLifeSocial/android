package com.refactoringlife.auth.features.login.domain.blocs

class LoginBlocs {
    companion object{
        fun getLoginBlocs() = listOf(HandleLoginBloc())
    }
}