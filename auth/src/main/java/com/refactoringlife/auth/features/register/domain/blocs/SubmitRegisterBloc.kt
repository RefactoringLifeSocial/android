package com.refactoringlife.auth.features.register.domain.blocs

import com.refactoringlife.auth.features.register.domain.usecases.RegisterResponseUseCase
import com.refactoringlife.auth.features.register.presentation.util.isEmailValid
import com.refactoringlife.auth.features.register.presentation.util.isPasswordMatch
import com.refactoringlife.auth.features.register.presentation.util.isPasswordValid
import com.refactoringlife.core.common.result.AsyncResult

class SubmitRegisterBloc(
    private val userRegisterResponseUseCase: RegisterResponseUseCase = RegisterResponseUseCase()
) : RegisterBaseBloc {

    override fun canHandle(event: RegisterEvent): Boolean {
        return event is RegisterEvent.SubmitRegister
    }

    override suspend fun handle(event: RegisterEvent, update: RegisterStateUpdate) {
        if (event is RegisterEvent.SubmitRegister) {

            val isEmailValid = event.email.isEmailValid()
            val isPasswordValid = event.password.isPasswordValid()
            val isPasswordMatchValid = event.password.isPasswordMatch(event.confirmPassword)

            val hasEmailError = !isEmailValid
            val hasPasswordError = !isPasswordValid
            val hasPasswordMatchError = !isPasswordMatchValid

            val isFormValid = isEmailValid && isPasswordValid && isPasswordMatchValid

            update { current ->
                current.copy(
                    hasEmailError = hasEmailError,
                    hasPasswordError = hasPasswordError,
                    hasPasswordMatchError = hasPasswordMatchError,
                    isFormValid = isFormValid
                )
            }
            if (!isFormValid) return

            val result = userRegisterResponseUseCase(event.email, event.password)
            when (result) {
                is AsyncResult.Success -> {
                    update { it.copy(isError = "") }
                }
                is AsyncResult.Failure -> {
                    update { it.copy(isError = result.error.message ?: "Error al registrar usuario") }
                }
            }
        }
    }
}
