package com.refactoringlife.auth.features.register.data.dto.request

import com.google.gson.annotations.SerializedName

data class UserRegisterRequest(
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("name")
    val name: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
)
