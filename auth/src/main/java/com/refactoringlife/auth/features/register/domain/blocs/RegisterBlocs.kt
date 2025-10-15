package com.refactoringlife.auth.features.register.domain.blocs

class RegisterBlocs {
    companion object {
        fun getRegisterBlocs() = listOf(HandleRegisterBloc())
    }
}
