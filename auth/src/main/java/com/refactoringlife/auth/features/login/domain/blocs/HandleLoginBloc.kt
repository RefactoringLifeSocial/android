package com.refactoringlife.auth.features.login.domain.blocs

import com.refactoringlife.auth.features.login.domain.state.LoginState
import com.refactoringlife.auth.features.login.utils.isValidEmail
import com.refactoringlife.auth.features.login.utils.isValidPassword
import com.refactoringlife.core.common.result.AsyncResult

class HandleLoginBloc : LoginBaseBloc {

    override fun canHandle(event: LoginEvent): Boolean = event is LoginEvent.Login

    override suspend fun handle(
        event: LoginEvent,
        update: suspend (suspend (LoginState) -> LoginState) -> Unit
    ) {
        if (event !is LoginEvent.Login) return

        val isValid = event.email.orEmpty().isValidEmail() && event.password.orEmpty().isValidPassword()
        if (!isValid){
            update{
                it.copy(loading = false, error = true, success = false)
            }
            return
        }

        update{it.copy(loading = true, error = false, success = true)}
    }
}
