package com.refactoringlife.auth.features.forgotpassword.presentation.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.refactoringlife.auth.R
import com.refactoringlife.auth.features.forgotpassword.presentation.composables.CodeInputComponent
import com.refactoringlife.auth.features.register.presentation.content.ButtonCustom
import com.refactoringlife.auth.features.register.presentation.theme.grayLight
import com.refactoringlife.auth.features.register.presentation.theme.purpleLight
import com.refactoringlife.auth.utils.theme.Purple40
import com.refactoringlife.auth.utils.theme.Purple80
import com.refactoringlife.core.common.utils.Constants.EMPTY
import com.refactoringlife.core.presentation.content.TextCustom

typealias code = String

@Composable
fun VerifyCodeView(
    onSendCode: (code) -> Unit = {}
){
    var code by remember { mutableStateOf(EMPTY) }

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        TextCustom(
            title = stringResource(id = R.string.thanks),
            fontSize = 36.sp,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.Start)
                .fillMaxWidth()
                .padding(start = 42.dp, top = 80.dp, bottom = 40.dp, end = 60.dp)
        )
        TextCustom(
            title = stringResource(id = R.string.message_send_code),
            fontSize = 28.sp,
            color = Color.Black,
            fontWeight = FontWeight.Light,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.Start)
                .fillMaxWidth()
                .padding(start = 42.dp, bottom = 80.dp, end = 60.dp)
        )
        CodeInputComponent(
            onCodeChanged = { newCode ->
                code = newCode
            },

        )
        Spacer(modifier = Modifier.weight(1f))

        //falta manejar mensaje de error segun state
//            Text(
//                text = stringResource(id = R.string.error_code_verify),
//                color = Red,
//                fontSize = 13.sp,
//                textAlign = TextAlign.Center,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 40.dp),
//            )

        Spacer(modifier = Modifier.height(10.dp))
        ButtonCustom(
            onClick = {
                onSendCode(code)
            },
            text = stringResource(id = R.string.send),
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
            title = stringResource(id = R.string.go_to_email),
            fontSize = 15.sp,
            color = Purple40,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        )

    }

}

@Preview(showBackground = true)
@Composable
fun PreviewVerifyCodeView(){
    VerifyCodeView()
}