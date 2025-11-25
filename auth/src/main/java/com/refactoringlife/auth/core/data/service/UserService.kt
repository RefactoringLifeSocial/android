package com.refactoringlife.auth.core.data.service

import com.refactoringlife.auth.features.forgotpassword.data.dto.request.UserSendEmailRequest
import com.refactoringlife.auth.features.forgotpassword.data.dto.request.UserResetPasswordRequest
import com.refactoringlife.auth.features.forgotpassword.data.dto.request.UserVerifyCodeRequest
import com.refactoringlife.auth.features.forgotpassword.data.dto.response.UserSendEmailResponse
import com.refactoringlife.auth.features.forgotpassword.data.dto.response.UserResetPasswordResponse
import com.refactoringlife.auth.features.forgotpassword.data.dto.response.UserVerifyCodeResponse
import com.refactoringlife.auth.features.login.data.dto.request.UserLoginRequest
import com.refactoringlife.auth.features.login.data.dto.responses.UserLoginResponse
import com.refactoringlife.auth.features.register.data.dto.request.UserRegisterRequest
import com.refactoringlife.auth.features.register.data.dto.responses.UserRegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {

    @POST("auth/register")
    suspend fun userRegister(
        @Body userRegisterRequest: UserRegisterRequest
    ): Response<UserRegisterResponse>

    @POST("auth/login")
    suspend fun userLogin(
        @Body userLoginRequest: UserLoginRequest
    ): Response<UserLoginResponse>

    @POST("auth/otp_send")
    suspend fun userSendEmailRecover(
        @Body userCode: UserSendEmailRequest
    ): Response<UserSendEmailResponse>

    @POST("auth/verify_code")
    suspend fun userSendCodeRecover(
        @Body userVerifyCode: UserVerifyCodeRequest
    ): Response<UserVerifyCodeResponse>

    @POST("auth/reset_password")
    suspend fun userResetPassword(
        @Body userNewPassword: UserResetPasswordRequest
    ): Response<UserResetPasswordResponse>
}
