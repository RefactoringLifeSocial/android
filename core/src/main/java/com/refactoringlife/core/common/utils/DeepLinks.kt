package com.refactoringlife.core.common.utils

object DeepLinks {
    const val SCHEME = "socialpets"
    const val HOST = "com.refactoringlife.socialpets"

    const val AUTH = "auth"
    const val LOGIN = "login"
    const val REGISTER = "register"

    object Routes {
        fun authLogin() = "/${AUTH}/${LOGIN}"
        fun authRegister() = "/${AUTH}/${REGISTER}"
    }
}
