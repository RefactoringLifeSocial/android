package com.refactoringlife.auth.features.login.data.datasource.service

import com.refactoringlife.auth.core.data.serviceProvider
import com.refactoringlife.auth.features.login.data.dto.request.UserLoginRequest
import com.refactoringlife.auth.features.login.data.dto.responses.UserLoginResponse
import com.refactoringlife.core.common.result.AsyncResult

class UserLoginServiceImp {

    suspend fun userLogin(userLoginRequest: UserLoginRequest): AsyncResult<UserLoginResponse?, Exception> {
        return try {
            val result = serviceProvider.userLogin(userLoginRequest)
            if (result.isSuccessful) {
                result.body()?.let { body ->
                    AsyncResult.Success(body)
                } ?: run {
                    AsyncResult.Failure(Exception("Empty response body"))
                }
            } else {
                AsyncResult.Failure(Exception("HTTP ${result.code()}: ${result.message()}"))
            }
        } catch (e: Exception) {
            AsyncResult.Failure(e)
        }
    }
}