package com.refactoringlife.auth.features.register.domain.blocs

import com.refactoringlife.auth.features.register.domain.usecases.RegisterResponseUseCase
import com.refactoringlife.auth.features.register.presentation.util.FormValidator
import com.refactoringlife.core.common.result.AsyncResult

class HandleRegisterBloc(
    val registerResponseUseCase: RegisterResponseUseCase = RegisterResponseUseCase(),
    private val formValidator: FormValidator = FormValidator()
) :
    RegisterBaseBloc {

    override fun canHandle(event: RegisterEvent): Boolean = event is RegisterEvent.UserRegister

    override suspend fun handle(
        event: RegisterEvent,
        update: RegisterStateUpdate
    ) {

        if (event !is RegisterEvent.UserRegister) return

        val validationResult = formValidator.validateForm(event)

        update { current ->
            current.copy(
                hasEmailError = validationResult.hasEmailError,
                hasPasswordError = validationResult.hasPasswordError,
                hasPasswordMatchError = validationResult.hasPasswordMatchError,
                isFormValid = validationResult.isFormValid,
                error = null
            )
        }

        if (!validationResult.isFormValid) return

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
