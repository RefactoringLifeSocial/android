package com.refactoringlife.core.common.utils

import android.content.Context
import android.content.Intent
import android.net.Uri

object DeepLinks {
    const val SCHEME = "socialpets"
    const val HOST = "com.refactoringlife.socialpets"

    object Host {
        const val AUTH = "auth"
        const val ADOPTION = "adoption"
        const val APP = "app"
    }

    object Path {
        const val LOGIN = "/login"
        const val REGISTER = "/register"
        const val ADOPTION_LIST = "/list"
        const val ADOPTION_DETAIL = "/detail"
        const val HOME = "/home"
    }

    fun buildUri(host: String, path: String, query: Map<String, String> = emptyMap()): Uri {
        val builder = Uri.Builder()
            .scheme(SCHEME)
            .authority(HOST)
            .path("/$host$path")
        query.forEach { (key, value) ->
            builder.appendQueryParameter(key, value)
        }
        return builder.build()
    }

    fun open(context: Context, uri: Uri) {
        val intent = Intent(Intent.ACTION_VIEW, uri).apply {
            addCategory(Intent.CATEGORY_BROWSABLE)
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
        }
        context.startActivity(intent)
    }

    // Auth Deep Links
    fun openAuthLogin(context: Context, query: Map<String, String> = emptyMap()) {
        open(context, buildUri(Host.AUTH, Path.LOGIN, query))
    }

    fun openAuthRegister(context: Context, query: Map<String, String> = emptyMap()) {
        open(context, buildUri(Host.AUTH, Path.REGISTER, query))
    }

    // Adoption Deep Links
    fun openAdoptionList(context: Context, query: Map<String, String> = emptyMap()) {
        open(context, buildUri(Host.ADOPTION, Path.ADOPTION_LIST, query))
    }

    fun openAdoptionDetail(context: Context, petId: String, query: Map<String, String> = emptyMap()) {
        open(context, buildUri(Host.ADOPTION, "${Path.ADOPTION_DETAIL}/$petId", query))
    }

    fun openAppHome(context: Context, query: Map<String, String> = emptyMap()) {
        open(context, buildUri(Host.APP, Path.HOME, query))
    }
}