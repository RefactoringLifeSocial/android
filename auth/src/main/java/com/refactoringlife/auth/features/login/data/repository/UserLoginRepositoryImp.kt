package com.refactoringlife.auth.features.login.data.repository

import com.refactoringlife.auth.features.login.data.datasource.service.UserLoginServiceImp
import com.refactoringlife.auth.features.login.data.dto.request.UserLoginRequest
import com.refactoringlife.auth.features.login.data.dto.responses.UserLoginResponse
import com.refactoringlife.auth.features.login.domain.repository.UserLoginRepository
import com.refactoringlife.core.common.result.AsyncResult

class UserLoginRepositoryImp(
    private val service : UserLoginServiceImp = UserLoginServiceImp()
):UserLoginRepository{
    override suspend fun userLogin(userLoginRequest : UserLoginRequest): AsyncResult<UserLoginResponse?, Exception> {
        val result = service.userLogin(userLoginRequest = userLoginRequest)
        return result
    }

}