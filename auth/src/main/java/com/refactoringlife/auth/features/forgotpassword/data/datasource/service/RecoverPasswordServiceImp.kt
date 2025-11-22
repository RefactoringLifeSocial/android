package com.refactoringlife.auth.features.forgotpassword.data.datasource.service

import com.refactoringlife.auth.core.data.serviceProvider
import com.refactoringlife.auth.features.forgotpassword.data.dto.request.UserSendEmailRequest
import com.refactoringlife.auth.features.forgotpassword.data.dto.request.UserVerifyCodeRequest
import com.refactoringlife.auth.features.forgotpassword.data.dto.response.UserSendEmailResponse
import com.refactoringlife.auth.features.forgotpassword.data.dto.response.UserVerifyCodeResponse
import com.refactoringlife.core.common.result.AsyncResult

class RecoverPasswordServiceImp {
    suspend fun sendEmail(userOtpSendRequest: UserSendEmailRequest): AsyncResult<UserSendEmailResponse?, Exception> {
        return try {
            val result = serviceProvider.userSendEmailRecover(userOtpSendRequest)
            if(result.isSuccessful) {
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

    suspend fun sendOtp(userVerifyCodeRequest: UserVerifyCodeRequest): AsyncResult<UserVerifyCodeResponse?, Exception> {
        return try {
            val result = serviceProvider.userSendCodeRecover(userVerifyCodeRequest)
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