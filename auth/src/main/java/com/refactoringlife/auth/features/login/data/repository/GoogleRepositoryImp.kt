package com.refactoringlife.auth.features.login.data.repository

import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.refactoringlife.auth.features.login.data.datasource.service.GoogleService
import com.refactoringlife.core.common.result.AsyncResult
import kotlinx.coroutines.tasks.await

class GoogleRepositoryImp(
    private val service: GoogleService = GoogleService()
) {
    suspend fun signInWithGoogle(token: String): AsyncResult<FirebaseUser, Exception> {
        return try {
            val credential = GoogleAuthProvider.getCredential(token, null)
            val authResult = service.auth.signInWithCredential(credential).await()
            val user = authResult.user
            if (user != null) {
                AsyncResult.Success(user)
            } else {
                AsyncResult.Failure(Exception("El usuario autenticado de Firebase es nulo"))
            }
        } catch (e: Exception) {
            AsyncResult.Failure(e)
        }
    }
}