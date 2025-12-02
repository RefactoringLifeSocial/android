package com.refactoringlife.core.common.utils

import android.net.Uri

object DeepLinkRouter {

    sealed class DeepLinkResult {
        data class ResetPassword(val token: String) : DeepLinkResult()
        object Unknown : DeepLinkResult()
    }

    fun parseDeepLink(uri: Uri?): DeepLinkResult {
        if (uri == null) return DeepLinkResult.Unknown

        val path = uri.path
        val scheme = uri.scheme

        if (path == DeepLinkPaths.RESET_PASSWORD_PATH) {
            val token = uri.getQueryParameter("token")
            if (!token.isNullOrEmpty() &&
                (scheme == DeepLinkPaths.RESET_PASSWORD_SCHEME_CUSTOM ||
                        scheme == DeepLinkPaths.RESET_PASSWORD_SCHEME_HTTPS)
            ) {
                return DeepLinkResult.ResetPassword(token)
            }
        }
        return DeepLinkResult.Unknown
    }
}
