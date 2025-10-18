package com.refactoringlife.auth.features.login.domain.blocs

import com.refactoringlife.auth.features.login.data.dto.request.UserLoginRequest
import com.refactoringlife.auth.features.login.domain.state.LoginState
import com.refactoringlife.auth.features.login.domain.usecases.UserLoginUserCase
import com.refactoringlife.auth.features.login.utils.isValidEmail
import com.refactoringlife.auth.features.login.utils.isValidPassword
import com.refactoringlife.core.common.result.AsyncResult

class HandleLoginBloc(
    private val userLoginUserCase: UserLoginUserCase = UserLoginUserCase()
): LoginBaseBloc {

    override fun canHandle(event: LoginEvent): Boolean = event is LoginEvent.Login

    override suspend fun handle(
        event: LoginEvent,
        update: suspend (suspend (LoginState) -> LoginState) -> Unit
    ) {
        if (event !is LoginEvent.Login) return

        val isValid = event.email.isValidEmail() && event.password.isValidPassword()
        if (!isValid){
            update{
                it.copy(loading = false, error = true)
            }
            return
        }

        val result = userLoginUserCase(userLoginRequest = UserLoginRequest(email = event.email, password = event.password))
        when(result){
            is AsyncResult.Failure -> {
                update{it.copy(error = true, errorMessage = result.error.message)}
            }
            is AsyncResult.Success -> {
                update{it.copy(data = result.value, success = true)}
            }
        }
    }
}
