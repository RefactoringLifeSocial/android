package com.refactoringlife.core.common.error

object HttpErrorCode {
    fun getErrorMessage(code: Int): String {
        return when (code) {
            400 -> "Solicitud incorrecta"
            401 -> "No autorizado"
            403 -> "Acceso prohibido"
            404 -> "Recurso no encontrado"
            408 -> "Tiempo de espera agotado"
            409 -> "Conflicto"
            422 -> "Datos inválidos"
            429 -> "Demasiadas solicitudes"
            500 -> "Error interno del servidor"
            502 -> "Servidor no disponible"
            503 -> "Servicio no disponible"
            504 -> "Tiempo de espera del servidor"
            else -> "Error del servidor: $code"
        }
    }

    fun isClientError(code: Int): Boolean {
        return code in 400..499
    }


    fun isServerError(code: Int): Boolean {
        return code in 500..599
    }
}