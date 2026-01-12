package com.refactoringlife.auth.features.login.domain.blocs

import com.refactoringlife.auth.features.login.domain.state.LoginState
import com.refactoringlife.auth.features.login.domain.usecases.GetTermsAcceptedUseCase
import com.refactoringlife.core.common.result.AsyncResult

class HandleLoadTermsAcceptedBloc(
    private val getTermsAcceptedUseCase: GetTermsAcceptedUseCase
) : LoginBaseBloc {

    override fun canHandle(event: LoginEvent): Boolean = event is LoginEvent.LoadTermsAccepted

    override suspend fun handle(
        event: LoginEvent,
        update: suspend (suspend (LoginState) -> LoginState) -> Unit
    ) {
        if (event !is LoginEvent.LoadTermsAccepted) return

        when (val result = getTermsAcceptedUseCase()) {
            is AsyncResult.Failure -> {
                update { current ->
                    current.copy(termsAccepted = false)
                }
            }
            is AsyncResult.Success -> {
                update { current ->
                    current.copy(termsAccepted = result.value)
                }
            }
        }
    }
}

