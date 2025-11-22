package com.refactoringlife.auth.features.forgotpassword.data.dto.response

import com.google.gson.annotations.SerializedName

data class UserSendEmailResponse (
    @SerializedName("message")
    val message: String?
)