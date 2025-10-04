package com.refactoringlife.auth.features.login.presentation.domain.blocs

import com.refactoringlife.auth.features.login.presentation.domain.state.LoginState

class HandleLoginBloc : LoginBaseBloc {

    override fun canHandle(event: LoginEvent): Boolean = event is LoginEvent.Login

    override suspend fun handle(
        event: LoginEvent,
        update: suspend (suspend (LoginState) -> LoginState) -> Unit
    ) {
        if (event !is LoginEvent.Login) return
        update { it.copy(loading = true, error = false) }
        try {
            /*
            call to use case
             update { it.copy(loading = false, error = false, success = true) }
             */

        } catch (_: Throwable) {
            // update { it.copy(loading = false, error = true) }
        }
    }
}
