package com.refactoringlife.auth.features.resetpassword.presentation.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.refactoringlife.auth.R
import com.refactoringlife.auth.features.register.presentation.content.TextFieldCustom
import com.refactoringlife.auth.features.register.presentation.theme.backgroundRegister
import com.refactoringlife.auth.features.register.presentation.theme.grayLight
import com.refactoringlife.auth.features.resetpassword.domain.state.ResetPasswordState
import com.refactoringlife.auth.features.resetpassword.presentation.viewmodel.ResetPasswordViewModel
import kotlinx.coroutines.launch

@Composable
fun ResetPasswordContent(
    state: ResetPasswordState,
    sendPassword: () -> Unit,
    viewModel: ResetPasswordViewModel
) {
    val scope = rememberCoroutineScope()
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
            text = stringResource(R.string.new_password),
            fontSize = 21.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.height(30.dp))
        TextFieldCustom(
            value = state.password,
            onValueChange = { email ->
                scope.launch {
                    viewModel.updateState(reducer = { state.copy(password = email) })
                }
            },
            placeholderText = stringResource(R.string.new_password),
            placeholderFontSize = 16.sp,
            placeHolderColor = grayLight,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(30.dp))
        TextFieldCustom(
            value = state.confirmPassword,
            onValueChange = { confirm ->
                scope.launch {
                    viewModel.updateState(reducer = { state.copy(confirmPassword = confirm) })
                }
            },
            placeholderText = stringResource(R.string.confirm_password),
            placeholderFontSize = 16.sp,
            placeHolderColor = grayLight,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                sendPassword()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = backgroundRegister
            ),
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 42.dp)
                .height(50.dp)
        ) {
            Text(
                text = "Guardar nueva contraseña",
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
