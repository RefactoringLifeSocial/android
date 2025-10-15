package com.refactoringlife.auth.features.login.domain.repository

import com.refactoringlife.auth.features.login.data.dto.request.UserLoginRequest
import com.refactoringlife.auth.features.login.data.dto.responses.UserLoginResponse
import com.refactoringlife.core.common.result.AsyncResult

interface UserLoginRepository {
    suspend fun userLogin(userLoginRequest: UserLoginRequest) : AsyncResult<UserLoginResponse?, Exception>
}