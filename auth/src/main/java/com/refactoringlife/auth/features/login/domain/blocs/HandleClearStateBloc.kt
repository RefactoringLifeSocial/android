package com.refactoringlife.auth.features.login.domain.blocs

import com.refactoringlife.auth.features.login.domain.state.LoginState
import com.refactoringlife.core.common.utils.Constants.EMPTY

class HandleClearStateBloc : LoginBaseBloc {

    override fun canHandle(event: LoginEvent): Boolean = event is LoginEvent.ClearState

    override suspend fun handle(
        event: LoginEvent,
        update: suspend (suspend (LoginState) -> LoginState) -> Unit
    ) {
        if (event !is LoginEvent.ClearState) return

        update { current ->
            current.copy(
                error = false,
                errorMessage = EMPTY,
                hasEmailError = false,
                hasPasswordError = false,
                loading = false,
                success = false
            )
        }
    }
}
