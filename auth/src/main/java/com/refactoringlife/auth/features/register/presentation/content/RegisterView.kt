package com.refactoringlife.auth.features.register.presentation.content

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.refactoringlife.auth.R
import com.refactoringlife.auth.features.register.presentation.theme.grayLight
import com.refactoringlife.auth.features.register.presentation.theme.purpleLight

@Composable
fun RegisterView(
    back: () -> Unit
) {
    BaseRegister(
        back = {
            back()
        },
        centerContent = {
            TextFieldCustom(
                value = "",
                onValueChange = { value ->

                },
                modifier = Modifier,
                placeholderText = stringResource(id = R.string.register_email),
                placeholderFontSize = 16.sp,
                icon = R.drawable.user,
                iconWidth = 25.dp,
                iconHeight = 25.dp,
                placeHolderColor = grayLight
            )

            Spacer(modifier = Modifier.height(50.dp))

            TextFieldCustom(
                value = "",
                onValueChange = { newValue ->

                },
                placeholderText = stringResource(id = R.string.register_password),
                placeholderFontSize = 16.sp,
                placeHolderColor = grayLight,
                icon = R.drawable.locked,
                iconWidth = 25.dp,
                iconHeight = 25.dp,
                modifier = Modifier
            )

            ShowPassword(
                checked = false,
                onCheckedChange = {

                },
                text = stringResource(id = R.string.register_show_password),
                textFontSize = 14.sp,
                textFontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(2.dp))

            TextFieldCustom(
                value = "",
                onValueChange = { newValue ->

                },
                placeholderText = stringResource(id = R.string.register_repeat_password),
                placeholderFontSize = 16.sp,
                placeHolderColor = grayLight,
                icon = R.drawable.locked,
                iconWidth = 25.dp,
                iconHeight = 25.dp,
                modifier = Modifier
            )

            ShowPassword(
                checked = false,
                onCheckedChange = {

                },
                text = stringResource(id = R.string.register_show_password),
                textFontSize = 14.sp,
                textFontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(70.dp))

            ButtonCustom(
                onClick = {

                },
                text = stringResource(id = R.string.register_button_),
                backgroundColor = purpleLight,
                textFontSize = 15.sp,
                textFontWeight = FontWeight.SemiBold
            )

        },
        bottomContent = {
            TextCustom(
                title = stringResource(id = R.string.register_communication_message),
                fontSize = 15.sp,
                color = grayLight,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 42.dp)
            )
        }
    )

}

@Composable
@Preview
fun PreviewRegisterView(){
    RegisterView {  }
}