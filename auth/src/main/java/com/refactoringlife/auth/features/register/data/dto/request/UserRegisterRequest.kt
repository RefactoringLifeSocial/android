package com.refactoringlife.auth.features.register.data.dto.request

import com.google.gson.annotations.SerializedName

data class UserRegisterRequest(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)
