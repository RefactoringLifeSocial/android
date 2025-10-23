package com.refactoringlife.auth.features.login.utils

import com.refactoringlife.auth.features.login.domain.blocs.LoginEvent
import com.refactoringlife.auth.features.login.domain.state.LoginState

class LoginFormValidator {

    fun validateForm(event: LoginEvent.Login): LoginState {
        val isEmailValid = event.email.isValidEmail()
        val isPasswordValid = event.password.isValidPassword()

        return LoginState(
            hasEmailError = !isEmailValid,
            hasPasswordError = !isPasswordValid,
            isFormValid = isEmailValid && isPasswordValid,
            success = false,
            loading = false,
            error = !isEmailValid || !isPasswordValid,
            errorMessage = ""
        )
    }
}
