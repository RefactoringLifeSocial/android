package com.refactoringlife.auth.features.login.utils

import android.content.Context
import android.content.Intent
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException

class GoogleUiClient(
    private val context: Context
) {
    private val googleSignInClient by lazy {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("")
            .requestEmail()
            .build()

        GoogleSignIn.getClient(context, gso)
    }

    fun signInIntent(): Intent = googleSignInClient.signInIntent

    fun getSignInResultFromIntent(intent: Intent): String? {
        val task = GoogleSignIn.getSignedInAccountFromIntent(intent)
        val account = task.getResult(ApiException::class.java)
        return account.idToken
    }
}