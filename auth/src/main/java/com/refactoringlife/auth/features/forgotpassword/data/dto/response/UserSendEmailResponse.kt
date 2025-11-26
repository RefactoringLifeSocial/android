package com.refactoringlife.auth.features.forgotpassword.data.dto.response

import com.google.gson.annotations.SerializedName

data class UserSendEmailResponse (
    @SerializedName("message")
    val message: String?,

    @SerializedName("token")
    val token: String? = null,
    
    @SerializedName("resetUrl")
    val resetUrl: String? = null
)
