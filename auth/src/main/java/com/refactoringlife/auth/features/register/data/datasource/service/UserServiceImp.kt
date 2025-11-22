package com.refactoringlife.auth.features.register.data.datasource.service

import com.refactoringlife.auth.core.data.serviceProvider
import com.refactoringlife.auth.features.forgotpassword.data.dto.request.UserSendEmailRequest
import com.refactoringlife.auth.features.forgotpassword.data.dto.response.UserSendEmailResponse
import com.refactoringlife.auth.features.register.data.dto.request.UserRegisterRequest
import com.refactoringlife.auth.features.register.data.dto.responses.UserRegisterResponse
import com.refactoringlife.core.common.result.AsyncResult

class UserServiceImp {
    suspend fun userRegister(
        userRegisterRequest: UserRegisterRequest
    ): AsyncResult<UserRegisterResponse?, Exception> {
        return try {
            val result = serviceProvider.userRegister(userRegisterRequest)
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

    suspend fun userSendEmail(
        userSendEmailRequest: UserSendEmailRequest
    ): AsyncResult<UserSendEmailResponse?, Exception> {
        return try {
            val result = serviceProvider.userSendEmailRecover(userSendEmailRequest)
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
