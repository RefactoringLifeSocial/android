package com.refactoringlife.auth.features.login.domain.blocs

import com.refactoringlife.auth.features.login.domain.state.LoginState
import com.refactoringlife.auth.features.login.domain.usecases.GoogleSignInUseCase
import com.refactoringlife.core.common.result.AsyncResult

class HandleLoginGoogleBloc(
    private val googleSignInUseCase: GoogleSignInUseCase = GoogleSignInUseCase()
) : LoginBaseBloc {
    override fun canHandle(event: LoginEvent): Boolean = event is LoginEvent.LoginGoogle

    override suspend fun handle(
        event: LoginEvent,
        update: suspend (suspend (LoginState) -> LoginState) -> Unit
    ) {
        if (event !is LoginEvent.LoginGoogle) return
        when (val result = googleSignInUseCase.invoke(token = event.token.toString())) {
            is AsyncResult.Failure -> {
                update { it.copy(error = true, errorMessage = result.error.message) }
            }

            is AsyncResult.Success -> {
                update { it.copy(success = true) }
            }
        }
    }
}