package com.refactoringlife.auth.features.register.domain.blocs

import com.refactoringlife.auth.features.login.domain.blocs.HandleLoginBloc

class RegisterBlocs {
    companion object {
        fun getLoginBlocs() = listOf(HandleRegisterBloc())
    }
}