package com.refactoringlife.auth.features.register.domain.blocs

import com.refactoringlife.auth.features.register.domain.usecases.RegisterResponseUseCase
import com.refactoringlife.auth.features.register.presentation.util.FormValidator
import com.refactoringlife.core.common.result.AsyncResult

class HandleRegisterBloc(
    private val userRegisterResponseUseCase: RegisterResponseUseCase = RegisterResponseUseCase(),
    private val formValidator: FormValidator = FormValidator()
) : RegisterBaseBloc {

    override fun canHandle(event: RegisterEvent): Boolean {
        return event is RegisterEvent.UserRegister
    }

    override suspend fun handle(event: RegisterEvent, update: RegisterStateUpdate) {
        if (event is RegisterEvent.UserRegister) {

            val validationResult = formValidator.validateForm(event)

            update { current ->
                current.copy(
                    hasEmailError = validationResult.hasEmailError,
                    hasPasswordError = validationResult.hasPasswordError,
                    hasPasswordMatchError = validationResult.hasPasswordMatchError,
                    isFormValid = validationResult.isFormValid
                )
            }

            if (!validationResult.isFormValid) return

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
