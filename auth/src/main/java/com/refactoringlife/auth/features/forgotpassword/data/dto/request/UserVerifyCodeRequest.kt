package com.refactoringlife.auth.features.forgotpassword.data.dto.request

import com.google.gson.annotations.SerializedName

class UserVerifyCodeRequest (
    @SerializedName("otp_code")
    val otpCode: String?
)