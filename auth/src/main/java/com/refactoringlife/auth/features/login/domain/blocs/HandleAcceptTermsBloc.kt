package com.refactoringlife.auth.features.login.domain.blocs

import com.refactoringlife.auth.features.login.domain.state.LoginState
import com.refactoringlife.auth.features.login.domain.usecases.SaveTermsAcceptedUseCase
import com.refactoringlife.core.common.result.AsyncResult

class HandleAcceptTermsBloc(
    private val saveTermsAcceptedUseCase: SaveTermsAcceptedUseCase
) : LoginBaseBloc {

    override fun canHandle(event: LoginEvent): Boolean = event is LoginEvent.AcceptTerms

    override suspend fun handle(
        event: LoginEvent,
        update: suspend (suspend (LoginState) -> LoginState) -> Unit
    ) {
        if (event !is LoginEvent.AcceptTerms) return

        when (val saveResult = saveTermsAcceptedUseCase(event.accepted)) {
            is AsyncResult.Failure -> {
                update { current ->
                    current.copy(
                        termsAccepted = !event.accepted,
                        error = true,
                        errorMessage = saveResult.error.message ?: "Error al guardar términos aceptados"
                    )
                }
                return
            }
            is AsyncResult.Success -> {
                update { current ->
                    current.copy(termsAccepted = event.accepted)
                }
            }
        }
    }
}
