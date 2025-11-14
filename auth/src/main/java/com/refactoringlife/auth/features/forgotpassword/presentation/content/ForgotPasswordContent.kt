package com.refactoringlife.auth.features.forgotpassword.presentation.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.refactoringlife.auth.R
import com.refactoringlife.auth.features.forgotpassword.domain.state.ForgotPasswordState
import com.refactoringlife.auth.features.register.presentation.content.ButtonCustom
import com.refactoringlife.auth.features.register.presentation.content.TextFieldCustom
import com.refactoringlife.auth.features.register.presentation.theme.backgroundRegister
import com.refactoringlife.auth.features.register.presentation.theme.grayLight

@Composable
fun ResetPasswordContent(
    sendEmail : () -> Unit,
    emailValue : (String) -> Unit,
    state : ForgotPasswordState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(80.dp))
        Image(
            painter = painterResource(R.drawable.logo_pets),
            contentDescription = "logo",
            modifier = Modifier
                .size(80.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = stringResource(R.string.forgot_password),
            fontSize = 21.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.height(30.dp))
        TextFieldCustom(
            value = state.email,
            onValueChange = {
                emailValue(it)
            },
            placeholderText = stringResource(R.string.input_email),
            placeholderFontSize = 16.sp,
            placeHolderColor = grayLight,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(30.dp))
        ButtonCustom(
            text = stringResource(R.string.send_email),
            onClick = {
                sendEmail()
            },
            backgroundColor = backgroundRegister,
            textFontSize = 16.5.sp,
            textFontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .height(50.dp)
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = stringResource(R.string.description_reset_password),
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = Color.LightGray,
            lineHeight = 14.sp,
            modifier = Modifier
                .widthIn(max = 290.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}
