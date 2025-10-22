package com.refactoringlife.auth.features.register.presentation.util

import android.util.Patterns

fun String?.isEmailValid(): Boolean {
    return if (this.isNullOrBlank()) false
    else Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String?.isPasswordValid(): Boolean {
    return if (this.isNullOrBlank()) false
    else this.length >= 6
}

fun String?.isPasswordMatch(confirmPassword: String?): Boolean {
    return this == confirmPassword && !this.isNullOrBlank()
}
