package com.refactoringlife.core.common.utils

object DeepLinks {
    const val SCHEME = "socialpets"
    const val HOST = "com.refactoringlife.socialpets"

    object Host {
        const val AUTH = "auth"
    }

    object Screen {
        const val LOGIN = "login"
        const val REGISTER = "register"
    }

    object Routes {
        fun authLogin() = "/${Host.AUTH}/${Screen.LOGIN}"
        fun authRegister() = "/${Host.AUTH}/${Screen.REGISTER}"
    }
}