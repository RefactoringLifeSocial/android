package com.refactoringlife.core.common.utils

import android.util.Patterns

fun String?.isValidEmail(): Boolean {
    return if (this.isNullOrBlank()) false
    else Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String?.isValidPassword(): Boolean {
    return if (this.isNullOrBlank()) false
    else this.length >= 6
}

fun String?.isPasswordMatch(confirmPassword: String?): Boolean {
    return this == confirmPassword && !this.isNullOrBlank()
}