package com.refactoringlife.core.common.utils

import android.net.Uri

object DeepLinkRouter {

    sealed class DeepLinkResult {
        data class ResetPassword(val token: String) : DeepLinkResult()
        object Unknown : DeepLinkResult()
    }

    fun parseDeepLink(uri: Uri?): DeepLinkResult {
        if (uri == null) return DeepLinkResult.Unknown
        val path = uri.path ?: ""
        val scheme = uri.scheme ?: ""

        if (path.startsWith(DeepLinkPaths.RESET_PASSWORD_PATH)) {
            val token = uri.getQueryParameter("token")
            val isCorrectScheme = scheme.equals("https", ignoreCase = true) ||
                    scheme.equals("huella", ignoreCase = true)

            if (!token.isNullOrEmpty() && isCorrectScheme) {
                return DeepLinkResult.ResetPassword(token)
            }
        }
        return DeepLinkResult.Unknown
    }
}
