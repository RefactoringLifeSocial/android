package com.refactoringlife.auth.features.login.domain.usecases

import com.google.firebase.auth.FirebaseUser
import com.refactoringlife.auth.features.login.data.repository.GoogleRepositoryImp
import com.refactoringlife.core.common.result.AsyncResult

class GoogleSignInUseCase(
    private val repository: GoogleRepositoryImp = GoogleRepositoryImp()
) {
    suspend operator fun invoke(token: String): AsyncResult<FirebaseUser, Exception> {
        return repository.signInWithGoogle(token = token)
    }
}