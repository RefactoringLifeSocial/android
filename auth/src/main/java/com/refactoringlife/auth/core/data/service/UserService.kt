package com.refactoringlife.auth.core.data.service

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
}
