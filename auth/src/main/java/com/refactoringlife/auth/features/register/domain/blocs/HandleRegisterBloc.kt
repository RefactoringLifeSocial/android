package com.refactoringlife.auth.features.register.domain.blocs

import com.refactoringlife.auth.features.register.domain.model.UserRegisterParams
import com.refactoringlife.auth.features.register.domain.usecases.RegisterResponseUseCase
import com.refactoringlife.auth.features.register.presentation.util.RegisterFormValidator
import com.refactoringlife.core.common.result.AsyncResult

class HandleRegisterBloc(
    val registerResponseUseCase: RegisterResponseUseCase = RegisterResponseUseCase(),
    private val formValidator: RegisterFormValidator = RegisterFormValidator()
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
                error = null,
                loading = false
            )
        }

        if (!validationResult.isFormValid) return

        val params = UserRegisterParams(
            name = event.name,
            country = event.country,
            address = event.address,
            phone = event.phone,
            email = event.email,
            password = event.password
        )

        update { it.copy(loading = true, error = null) }

        when (val result = registerResponseUseCase(params)) {

            is AsyncResult.Failure -> {
                update {
                    it.copy(loading = false, error = result.error.message, data = null)
                }
            }

            is AsyncResult.Success -> {
                update {
                    it.copy(loading = false, error = null, data = result.value, success = true)
                }
            }
        }
    }
}
