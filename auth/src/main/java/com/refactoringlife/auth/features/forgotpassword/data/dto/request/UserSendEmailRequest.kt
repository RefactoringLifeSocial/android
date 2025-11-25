package com.refactoringlife.auth.features.forgotpassword.data.dto.request

import com.google.gson.annotations.SerializedName

data class UserSendEmailRequest(
    @SerializedName("email")
    val email: String?
)
