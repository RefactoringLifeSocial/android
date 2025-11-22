package com.refactoringlife.auth.features.forgotpassword.data.dto.request

import com.google.gson.annotations.SerializedName

data class UserResetPasswordRequest (
    @SerializedName("new_password")
    val newPassword: String?
)