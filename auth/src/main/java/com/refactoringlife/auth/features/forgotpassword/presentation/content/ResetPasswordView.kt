package com.refactoringlife.auth.features.forgotpassword.presentation.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.refactoringlife.auth.R
import com.refactoringlife.auth.features.register.presentation.content.ButtonCustom
import com.refactoringlife.auth.features.register.presentation.content.ShowPassword
import com.refactoringlife.auth.features.register.presentation.content.TextFieldCustom
import com.refactoringlife.auth.features.register.presentation.theme.grayLight
import com.refactoringlife.auth.features.register.presentation.theme.purpleLight
import com.refactoringlife.core.common.utils.Constants.EMPTY
import com.refactoringlife.core.presentation.content.TextCustom

typealias password = String

@Composable
fun ResetPasswordView(
    onConfirm: (password) -> Unit = {}
) {

    var password by remember { mutableStateOf(EMPTY) }
    var confirmPassword by remember { mutableStateOf(EMPTY) }
    var showPassword by remember { mutableStateOf(false) }
    var showConfirmPassword by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize()) {

        TextCustom(
            title = stringResource(id = R.string.new_password),
            fontSize = 36.sp,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .align(Alignment.Start)
                .fillMaxWidth()
                .padding(start = 42.dp, top = 80.dp, bottom = 40.dp, end = 60.dp)
        )

        TextFieldCustom(
            value = password,
            onValueChange = { newValue ->
                password = newValue
            },
            placeholderText = stringResource(id = R.string.register_password),
            placeholderFontSize = 16.sp,
            placeHolderColor = grayLight,
            icon = R.drawable.locked,
            iconWidth = 25.dp,
            iconHeight = 25.dp,
            modifier = Modifier,
            isPassword = true,
            showPassword = showPassword
        )

        ShowPassword(
            checked = showPassword,
            onCheckedChange = { showPassword = it },
            text = stringResource(id = R.string.register_show_password),
            textFontSize = 14.sp,
            textFontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(2.dp))

        TextFieldCustom(
            value = confirmPassword,
            onValueChange = { newValue ->
                confirmPassword = newValue
            },
            placeholderText = stringResource(id = R.string.register_repeat_password),
            placeholderFontSize = 16.sp,
            placeHolderColor = grayLight,
            icon = R.drawable.locked,
            iconWidth = 25.dp,
            iconHeight = 25.dp,
            modifier = Modifier,
            isPassword = true,
            showPassword = showConfirmPassword
        )

        ShowPassword(
            checked = showConfirmPassword,
            onCheckedChange = { showConfirmPassword = it },
            text = stringResource(id = R.string.register_show_password),
            textFontSize = 14.sp,
            textFontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.weight(1f))

        ButtonCustom(
            onClick = {
                onConfirm(password)
            },
            text = stringResource(id = R.string.confirm),
            backgroundColor = purpleLight,
            textFontSize = 15.sp,
            textFontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(bottom = 30.dp)
        )

        HorizontalDivider(
            modifier = Modifier
                .padding(start = 30.dp, end = 30.dp, bottom = 30.dp)
        )
        TextCustom(
            title = stringResource(id = R.string.register_communication_message),
            fontSize = 15.sp,
            color = grayLight,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 42.dp, bottom = 20.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewResetPasswordView() {
    ResetPasswordView()
}