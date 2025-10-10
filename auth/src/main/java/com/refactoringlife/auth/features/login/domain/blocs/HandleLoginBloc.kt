package com.refactoringlife.auth.features.login.domain.blocs

import com.refactoringlife.auth.features.login.domain.state.LoginState
import com.refactoringlife.core.common.result.AsyncResult

class HandleLoginBloc : LoginBaseBloc {

    private val validation = Validation()

    override fun canHandle(event: LoginEvent): Boolean = event is LoginEvent.Login

    override suspend fun handle(
        event: LoginEvent,
        update: suspend (suspend (LoginState) -> LoginState) -> Unit
    ) {
        if (event !is LoginEvent.Login) return

        val isValid = validation.emailAndPassword(email = event.email ?: "", password = event.password ?: "")
        if (!isValid){
            update{
                it.copy(loading = false, error = true, success = false)
            }
            return
        }

        update{it.copy(loading = true, error = false, success = true)}
    }
}

class Validation {

    private val regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$".toRegex()

    fun emailAndPassword(email : String, password : String): Boolean{
        if (email.isBlank()){
            return false
        }
        if (password.length < 8){
            return false
        }
        if (password.isBlank()){
            return false
        }
        if (!email.matches(regex = regex)){
            return false
        }
        return true
    }
}
