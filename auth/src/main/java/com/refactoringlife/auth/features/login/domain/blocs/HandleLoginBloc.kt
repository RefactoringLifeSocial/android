package com.refactoringlife.auth.features.login.domain.blocs

import com.refactoringlife.auth.features.login.data.dto.request.UserLoginRequest
import com.refactoringlife.auth.features.login.domain.state.LoginState
import com.refactoringlife.auth.features.login.domain.usecases.UserLoginUserCase
import com.refactoringlife.auth.features.login.utils.LoginFormValidator
import com.refactoringlife.core.common.result.AsyncResult

class HandleLoginBloc(
    private val userLoginUserCase: UserLoginUserCase = UserLoginUserCase(),
    private val formValidator: LoginFormValidator = LoginFormValidator()
): LoginBaseBloc {

    override fun canHandle(event: LoginEvent): Boolean = event is LoginEvent.Login

    override suspend fun handle(
        event: LoginEvent,
        update: suspend (suspend (LoginState) -> LoginState) -> Unit
    ) {
        if (event !is LoginEvent.Login) return

        val validationResult = formValidator.validateForm(event)

        update { current ->
            current.copy(
                hasEmailError = validationResult.hasEmailError,
                hasPasswordError = validationResult.hasPasswordError,
                isFormValid = validationResult.isFormValid
            )
        }

        if (!validationResult.isFormValid) return

        val result = userLoginUserCase(userLoginRequest = UserLoginRequest(email = event.email, password = event.password))
        when(result){
            is AsyncResult.Failure -> {
                update{it.copy(error = true, errorMessage = result.error.message ?: "Error en el login")}
            }
            is AsyncResult.Success -> {
                update{it.copy(error = false, errorMessage = "")}
            }
        }
    }
}
