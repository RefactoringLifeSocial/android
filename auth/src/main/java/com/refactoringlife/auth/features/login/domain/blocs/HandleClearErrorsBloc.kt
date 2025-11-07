package com.refactoringlife.auth.features.login.domain.blocs

import com.refactoringlife.auth.features.login.domain.state.LoginState

class HandleClearErrorsBloc : LoginBaseBloc {

    override fun canHandle(event: LoginEvent): Boolean = event is LoginEvent.ClearErrors

    override suspend fun handle(
        event: LoginEvent,
        update: suspend (suspend (LoginState) -> LoginState) -> Unit
    ) {
        if (event !is LoginEvent.ClearErrors) return

        update { current ->
            current.copy(
                error = false,
                errorMessage = "",
                hasEmailError = false,
                hasPasswordError = false
            )
        }
    }
}
