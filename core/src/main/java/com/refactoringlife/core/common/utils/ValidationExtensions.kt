package com.refactoringlife.core.common.utils

private val EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$".toRegex()

fun String?.isValidEmail(): Boolean {
    return if (this.isNullOrBlank()) false
    else EMAIL_REGEX.matches(this)
}

fun String?.isValidPassword(): Boolean {
    return if (this.isNullOrBlank()) false
    else this.length >= 6
}

fun String?.isPasswordMatch(confirmPassword: String?): Boolean {
    return this == confirmPassword && !this.isNullOrBlank()
}
fun String.isAllowedInput(): Boolean {
    val regex = Regex("[-a-zA-Z0-9\\s.,!?;:\"'()&@$#%*+]*")
    return this.matches(regex)
}
