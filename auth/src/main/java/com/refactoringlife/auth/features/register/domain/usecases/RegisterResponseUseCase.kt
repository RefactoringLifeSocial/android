package com.refactoringlife.auth.features.register.domain.usecases

import com.refactoringlife.auth.features.register.data.dto.responses.UserRegisterResponse
import com.refactoringlife.auth.features.register.data.repository.UserRepositoryImp
import com.refactoringlife.auth.features.register.domain.repository.UserRepository
import com.refactoringlife.core.common.result.AsyncResult

class RegisterResponseUseCase(private val repository: UserRepository = UserRepositoryImp()) {

    suspend operator fun invoke(email: String, password: String): AsyncResult<UserRegisterResponse?, Exception> {
        return repository.userRegister(email, password) // capturar el caso con when y modelar con toModel
    }
}