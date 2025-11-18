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

        if (event.token == null) {
            update { it.copy(
                error = true,
                errorMessage = "Error al obtener el token de Google",
                loading = false)
            }
            return
        }
        update { it.copy(
            loading = true,
            error = false)
        }

        when (val result = googleSignInUseCase.invoke(token = event.token)) {
            is AsyncResult.Failure -> {
                update { it.copy(
                    error = true,
                    errorMessage = result.error.message,
                    loading = false)
                }
            }

            is AsyncResult.Success -> {
                update { it.copy(
                    success = true,
                    loading = false)
                }
            }
        }
    }
}