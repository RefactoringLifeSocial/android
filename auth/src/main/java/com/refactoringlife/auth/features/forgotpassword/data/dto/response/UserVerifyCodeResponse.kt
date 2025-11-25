package com.refactoringlife.auth.features.forgotpassword.data.dto.response

import com.google.gson.annotations.SerializedName

data class UserVerifyCodeResponse(
    @SerializedName("access_token")
    val accessToken: String?,
    @SerializedName("refresh_token")
    val refreshToken: String?
)
