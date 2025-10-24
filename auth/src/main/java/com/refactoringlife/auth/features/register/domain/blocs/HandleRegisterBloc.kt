package com.refactoringlife.auth.features.register.domain.blocs

import com.refactoringlife.auth.features.register.domain.usecases.RegisterResponseUseCase
import com.refactoringlife.core.common.result.AsyncResult
import com.refactoringlife.core.common.utils.isValidEmail
import com.refactoringlife.core.common.utils.isValidPassword

class HandleRegisterBloc(val registerResponseUseCase: RegisterResponseUseCase = RegisterResponseUseCase()) :
    RegisterBaseBloc {

    override fun canHandle(event: RegisterEvent): Boolean = event is RegisterEvent.UserRegister

    override suspend fun handle(
        event: RegisterEvent,
        update: RegisterStateUpdate
    ) {

        if (event !is RegisterEvent.UserRegister) return

        val isValid = event.email.isValidEmail() && event.password.isValidPassword()

        if (!isValid) {
            update {
                it.copy(loading = false, error = "Not valid credentials")
            }
            return
        }

        val result = registerResponseUseCase(event.email, event.password)
        when (result) {

            is AsyncResult.Failure -> {
                update {
                    it.copy(loading = false, error = result.error.message, data = null)
                }
            }

            is AsyncResult.Success -> {
                update {
                    it.copy(loading = false, error = null, data = result.value)
                }
            }
        }
    }
}
