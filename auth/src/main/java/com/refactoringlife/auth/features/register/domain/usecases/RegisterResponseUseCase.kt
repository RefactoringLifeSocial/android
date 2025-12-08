package com.refactoringlife.auth.features.register.domain.usecases

import com.refactoringlife.auth.features.register.data.repository.UserRepositoryImp
import com.refactoringlife.auth.features.register.domain.mappers.toUserRegisterModel
import com.refactoringlife.auth.features.register.domain.model.UserRegisterModel
import com.refactoringlife.core.common.result.AsyncResult

class RegisterResponseUseCase(val repositoryImp: UserRepositoryImp = UserRepositoryImp()) {
    suspend operator fun invoke(
        name: String,
        country: String,
        address: String,
        phone: String,
        email: String,
        password: String
    ): AsyncResult<UserRegisterModel?, Exception> {
        return when (val result = repositoryImp.userRegister(
            name, country, address, phone, email, password
        )) {
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
