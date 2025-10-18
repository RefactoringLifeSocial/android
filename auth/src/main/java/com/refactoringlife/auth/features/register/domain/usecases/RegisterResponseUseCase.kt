package com.refactoringlife.auth.features.register.domain.usecases

<<<<<<< HEAD
import com.refactoringlife.auth.features.register.data.repository.UserRepositoryImp
import com.refactoringlife.auth.features.register.domain.mappers.toUserRegisterModel
import com.refactoringlife.auth.features.register.domain.model.UserRegisterModel
import com.refactoringlife.core.common.result.AsyncResult

class RegisterResponseUseCase(val repositoryImp: UserRepositoryImp = UserRepositoryImp()) {
    suspend operator fun invoke(
        email: String,
        password: String
    ): AsyncResult<UserRegisterModel?, Exception> {
        return when (val result = repositoryImp.userRegister(email, password)) {
            is AsyncResult.Failure -> {
                AsyncResult.Failure(error = result.error)
            }

            is AsyncResult.Success -> {
                result.value?.let { response ->
                    AsyncResult.Success(response.toUserRegisterModel())
                } ?: AsyncResult.Failure(Exception("Data is null"))
            }
        }
    }
}
=======
import com.refactoringlife.auth.features.register.data.dto.responses.UserRegisterResponse
import com.refactoringlife.auth.features.register.data.repository.UserRepositoryImp
import com.refactoringlife.auth.features.register.domain.repository.UserRepository
import com.refactoringlife.core.common.result.AsyncResult

class RegisterResponseUseCase(private val repository: UserRepository = UserRepositoryImp()) {

    suspend operator fun invoke(email: String, password: String): AsyncResult<UserRegisterResponse?, Exception> {
        return repository.userRegister(email, password) // capturar el caso con when y modelar con toModel
    }
}
>>>>>>> cf1339427d9ed1a6a5a263e941094abb28b934df
