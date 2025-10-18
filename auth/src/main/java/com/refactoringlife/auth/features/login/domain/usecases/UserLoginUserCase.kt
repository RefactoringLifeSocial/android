package com.refactoringlife.auth.features.login.domain.usecases

import com.refactoringlife.auth.features.login.data.dto.request.UserLoginRequest
import com.refactoringlife.auth.features.login.data.repository.UserLoginRepositoryImp
import com.refactoringlife.auth.features.login.domain.mappers.LoginResponseDataMapper
import com.refactoringlife.auth.features.login.domain.model.UserLoginModel
import com.refactoringlife.auth.features.login.domain.repository.UserLoginRepository
import com.refactoringlife.core.common.result.AsyncResult

class UserLoginUserCase(
    private val repository: UserLoginRepository = UserLoginRepositoryImp()
) {
    suspend operator fun invoke(userLoginRequest: UserLoginRequest): AsyncResult<UserLoginModel?, Exception> {
        return when (val result = repository.userLogin(userLoginRequest = userLoginRequest)) {
            is AsyncResult.Failure -> {
                AsyncResult.Failure(error = result.error)
            }
            is AsyncResult.Success -> {
                val data: UserLoginModel? = result.value?.let {
                    LoginResponseDataMapper.map(response = it)
                }
                AsyncResult.Success(value = data)
            }
        }
    }
}