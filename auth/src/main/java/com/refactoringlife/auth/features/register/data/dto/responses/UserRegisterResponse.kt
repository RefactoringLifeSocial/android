package com.refactoringlife.auth.features.register.data.dto.responses

import com.google.gson.annotations.SerializedName

data class UserRegisterResponse(
    @SerializedName("message")
    val message: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("error_code")
    val errorCode: String?
)