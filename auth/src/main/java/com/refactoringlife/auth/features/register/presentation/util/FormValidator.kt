package com.refactoringlife.auth.features.register.presentation.util

import com.refactoringlife.auth.features.register.domain.blocs.RegisterEvent
import com.refactoringlife.auth.features.register.presentation.state.RegisterState

class FormValidator {

    fun validateForm(event: RegisterEvent.SubmitRegister): RegisterState {
        val isEmailValid = event.email.isEmailValid()
        val isPasswordValid = event.password.isPasswordValid()
        val isPasswordMatchValid = event.password.isPasswordMatch(event.confirmPassword)

        return RegisterState(
            hasEmailError = !isEmailValid,
            hasPasswordError = !isPasswordValid,
            hasPasswordMatchError = !isPasswordMatchValid,
            isFormValid = isEmailValid && isPasswordValid && isPasswordMatchValid
        )
    }
}
