package com.refactoringlife.auth.features.register.domain.blocs

import com.refactoringlife.auth.features.register.domain.usecases.RegisterResponseUseCase
import com.refactoringlife.core.common.result.AsyncResult

class SubmitRegisterBloc(
    private val userRegisterResponseUseCase: RegisterResponseUseCase = RegisterResponseUseCase()
) : RegisterBaseBloc {

    override fun canHandle(event: RegisterEvent): Boolean {
        return event is RegisterEvent.SubmitRegister
    }

    override suspend fun handle(event: RegisterEvent, update: RegisterStateUpdate) {
        if (event is RegisterEvent.SubmitRegister) {

            val isEmailValid = event.email.isNotBlank() && event.email.contains("@")
            val isPasswordValid = event.password.isNotBlank() && event.password.length >= 6
            val isPasswordMatchValid = event.password.isNotBlank() && event.password == event.confirmPassword

            val emailError = if (!isEmailValid) "El email no es valido" else null
            val passwordError = when {
                !isPasswordValid -> "La contraseña debe tener al menos 6 caracteres"
                !isPasswordMatchValid -> "Las contraseñas no coinciden"
                else -> null
            }

            val isFormValid = isEmailValid && isPasswordValid && isPasswordMatchValid

            update { current ->
                current.copy(
                    isEmailValid = isEmailValid,
                    isPasswordValid = isPasswordValid,
                    isPasswordMatchValid = isPasswordMatchValid,
                    emailError = emailError,
                    passwordError = passwordError,
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
