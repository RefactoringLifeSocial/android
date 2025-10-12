package com.refactoringlife.core.common.utils

object DeepLinks {
    const val SCHEME = "socialpets"
    const val HOST = "com.refactoringlife.socialpets"

    object Host {
        const val AUTH = "auth"
    }

    // UNA SOLA DEFINICIÓN DE PANTALLAS
    object Screen {
        const val LOGIN = "login"
        const val REGISTER = "register"
    }

    // CONSTRUCTOR DE RUTAS COMPLETAS
    object Routes {
        fun authLogin() = "/${Host.AUTH}/${Screen.LOGIN}"      // "/auth/login"
        fun authRegister() = "/${Host.AUTH}/${Screen.REGISTER}" // "/auth/register"
    }
}