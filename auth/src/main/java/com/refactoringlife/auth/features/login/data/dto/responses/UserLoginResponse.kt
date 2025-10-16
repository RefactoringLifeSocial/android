package com.refactoringlife.auth.features.login.data.dto.responses

import com.google.gson.annotations.SerializedName

data class UserLoginResponse(
    @SerializedName("access_token")
    val accessToken : String?,
    @SerializedName("refresh_token")
    val refreshToken : String?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("error_code")
    val errorCode: String?
)
