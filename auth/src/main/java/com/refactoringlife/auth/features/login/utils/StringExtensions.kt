package com.refactoringlife.auth.features.login.utils

private val regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$".toRegex()

fun String?.isValidEmail():Boolean{
    return this?.let {
        it.isNotBlank() && it.matches(regex)
    } ?: false
}
fun String?.isValidPassword():Boolean{
    return this?.let {
        it.isNotBlank() && it.length >= 8
    } ?: false
}