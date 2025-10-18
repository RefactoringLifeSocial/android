package com.refactoringlife.auth.features.register.domain.blocs

import com.refactoringlife.auth.features.login.utils.isValidEmail
import com.refactoringlife.auth.features.login.utils.isValidPassword
import com.refactoringlife.auth.features.register.domain.usecases.RegisterResponseUseCase
import com.refactoringlife.core.common.result.AsyncResult

class HandleRegisterBloc(val registerResponseUseCase: RegisterResponseUseCase = RegisterResponseUseCase()) :
    RegisterBaseBloc {

    override fun canHandle(event: RegisterEvent): Boolean = event is RegisterEvent.Register

    override suspend fun handle(
        event: RegisterEvent,
        update: RegisterStateUpdater
    ) {

        if (event !is RegisterEvent.Register) return

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
