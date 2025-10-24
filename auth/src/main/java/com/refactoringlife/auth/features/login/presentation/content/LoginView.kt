package com.refactoringlife.auth.features.login.presentation.content

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.refactoringlife.auth.R
import com.refactoringlife.auth.features.login.domain.state.LoginState
import com.refactoringlife.auth.features.login.presentation.theme.BackgroundColor
import com.refactoringlife.auth.features.login.presentation.theme.Black50
import com.refactoringlife.auth.features.login.presentation.theme.DividerColor
import com.refactoringlife.auth.features.login.presentation.theme.GrayLight
import com.refactoringlife.auth.features.login.presentation.theme.PurpleLight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginView(
    onBack: () -> Unit,
    onLoginClick: (email : String, password : String) -> Unit,
    onForgotPassword: () -> Unit,
    onRegisterClick: () -> Unit,
    state: LoginState,

) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    val errorMessage = when {
        state.hasEmailError -> stringResource(R.string.error_login_generic)
        state.hasPasswordError -> stringResource(R.string.error_login_generic)
        state.errorMessage?.isNotEmpty() == true -> state.errorMessage
        else -> null
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = BackgroundColor
    ) {
        Box(modifier = Modifier.fillMaxSize()) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
                    .padding(top = 32.dp, start = 16.dp),
                horizontalAlignment = Alignment.Start
            ) {
                IconButton(onClick = onBack) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrowback),
                        contentDescription = stringResource(R.string.volver),
                        tint = Color.Black,
                        modifier = Modifier.size(24.dp)
                    )
                }
                Spacer(modifier = Modifier.height(70.dp))
                Text(
                    text = stringResource(R.string.iniciar_sesion),
                    fontSize = 36.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 26.dp)
                )
            }


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(80.dp))

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    singleLine = true,
                    isError = state.hasEmailError,
                    placeholder = {
                        Text(
                            text = stringResource(R.string.email),
                            fontSize = 16.sp,
                            color = GrayLight
                        )
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.person),
                            contentDescription = null,
                            modifier = Modifier.size(26.dp),
                            tint = Color.Black
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 42.dp)
                        .height(56.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    singleLine = true,
                    isError = state.hasPasswordError,
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    placeholder = {
                        Text(
                            text = stringResource(R.string.contrasena),
                            fontSize = 16.sp,
                            color = GrayLight
                        )
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.candado),
                            contentDescription = null,
                            modifier = Modifier.size(26.dp),
                            tint = Color.Black
                        )
                    },
                    trailingIcon = {
                        if (state.hasPasswordError) {
                            Icon(
                                imageVector = Icons.Default.Warning,
                                contentDescription = null,
                                tint = Color.Red,
                                modifier = Modifier.size(20.dp)
                            )
                        } else {
                            Icon(
                                imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                contentDescription = null,
                                modifier = Modifier.clickable { passwordVisible = !passwordVisible }
                            )
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 42.dp)
                        .height(56.dp)
                )


                Spacer(modifier = Modifier.height(40.dp))
                if (errorMessage != null) {
                    Text(
                        text = errorMessage,
                        color = Color.Red,
                        fontSize = 13.sp,
                        modifier = Modifier
                            .padding(start = 42.dp, top = 8.dp)
                            .align(Alignment.Start)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = { onLoginClick(email, password) },
                    shape = RoundedCornerShape(12.dp),
                    enabled = true,
                    colors = ButtonDefaults.buttonColors(
                        containerColor =  PurpleLight
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 42.dp)
                        .height(48.dp)
                ) {
                    Text(
                        text = stringResource(R.string.entrar),
                        color = Color.White,
                        fontSize = 16.sp,
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = stringResource(R.string.olvidaste_contrasena),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier
                        .clickable { onForgotPassword() }
                        .padding(horizontal = 42.dp),
                )
            }


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HorizontalDivider(
                    color = DividerColor,
                    thickness = 1.dp,
                    modifier = Modifier.padding(horizontal = 32.dp, vertical = 16.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 32.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.sin_cuenta),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                        color = GrayLight
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = stringResource(R.string.registrate_aqui),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Black50,
                        modifier = Modifier.clickable { onRegisterClick() }
                    )
                }
            }
        }
    }
}
