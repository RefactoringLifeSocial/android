package com.refactoringlife.auth.features.register.presentation.util

import com.refactoringlife.auth.features.register.domain.blocs.RegisterEvent
import com.refactoringlife.auth.features.register.domain.state.RegisterState
import com.refactoringlife.core.common.utils.isPasswordMatch
import com.refactoringlife.core.common.utils.isValidEmail
import com.refactoringlife.core.common.utils.isValidPassword

class RegisterFormValidator {

    fun validateForm(event: RegisterEvent.UserRegister): RegisterState {
        val isNameValid = event.name.isNotBlank()
        val isCountryValid = event.country.isNotBlank()
        val isAddressValid = event.address.isNotBlank()
        val isPhoneValid = event.phone.isNotBlank()
        val isEmailValid = event.email.isValidEmail()
        val isPasswordValid = event.password.isValidPassword()
        val isPasswordMatchValid = event.password.isPasswordMatch(event.confirmPassword)

        return RegisterState(
            hasEmailError = !isEmailValid,
            hasPasswordError = !isPasswordValid,
            hasPasswordMatchError = !isPasswordMatchValid,
            isFormValid = isNameValid && isCountryValid && isAddressValid &&
                    isPhoneValid && isEmailValid && isPasswordValid &&
                    isPasswordMatchValid
        )
    }
}
