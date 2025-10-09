package com.refactoringlife.auth.features.login.presentation.content


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import com.refactoringlife.core.R
import androidx.compose.ui.res.stringResource


@Composable
fun LoginView(
    onBack: () -> Unit,
    onLoginClick: (String, String) -> Unit,
    onForgotPassword: () -> Unit,
    onRegisterClick: () -> Unit
) {
    BaseLogin(
        topContent = {
            Box(modifier = Modifier.fillMaxWidth().padding(start = 16.dp)) {
                BackIconLogin(
                    onBack = onBack,
                    image = R.drawable.arrowback,
                    width = 24.dp,
                    height = 24.dp,
                    modifier = Modifier,
                )
            }
            Spacer(modifier = Modifier.height(70.dp))
            Box(modifier = Modifier.fillMaxWidth()) {
                TextLogin(
                    text = stringResource(R.string.iniciar_sesion),
                    fontSize = 36.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 42.dp)
                )
            }
        },

        middleContent = {
            Spacer(modifier = Modifier.height(80.dp))
            TextFieldLogin(
                value = "",
                onValueChange = {},
                placeholderText = stringResource(R.string.email),
                placeholderFontSize = 16.sp,
                icon = R.drawable.user,
                iconWidth = 25.dp,
                iconHeight = 25.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 42.dp)
            )
            Spacer(modifier = Modifier.height(50.dp))
            TextFieldLogin(
                value = "",
                onValueChange = {},
                placeholderText = stringResource(R.string.contrasena),
                placeholderFontSize = 16.sp,
                icon = R.drawable.candado,
                iconWidth = 25.dp,
                iconHeight = 25.dp,
                showPassword = false,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 42.dp)
            )
            Spacer(modifier = Modifier.height(1.dp))
            ShowPasswordLogin(
                checked = false,
                onCheckedChange = {},
                text = stringResource(R.string.mostrar_contrasena),
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 2.dp)
                    .fillMaxWidth(),
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(32.dp))
            ButtonLogin(
                text = stringResource(R.string.entrar),
                onClick = { onLoginClick("", "") },
                backgroundColor = Color(0xFF7353BA),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                textFontSize = 16.sp,
                textFontWeight = FontWeight.Normal,
            )
            Spacer(modifier = Modifier.height(24.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 42.dp),
                contentAlignment = Alignment.Center
            ) {
                TextLogin(
                    text = stringResource(R.string.olvidaste_contrasena),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.clickable { onForgotPassword() }
                )
            }
        },

        bottomContent = {
            HorizontalDivider(
                color = Color.Black.copy(alpha = 0.1f),
                thickness = 1.dp,
                modifier = Modifier.padding(horizontal = 32.dp, vertical = 16.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Row {
                    TextLogin(
                        text = stringResource(R.string.sin_cuenta),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.width(1.dp))
                    TextLogin(
                        text = stringResource(R.string.registrate_aqui),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Black,
                        color = Color.Gray,
                        modifier = Modifier.clickable { onRegisterClick() }
                    )
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginView() {
    val context = androidx.compose.ui.platform.LocalContext.current
    androidx.compose.material3.MaterialTheme {
        androidx.compose.material3.Surface {
            androidx.compose.runtime.CompositionLocalProvider(
                androidx.compose.ui.platform.LocalContext provides context
            ) {
                LoginView(
                    onBack = {},
                    onLoginClick = { _, _ -> },
                    onForgotPassword = {},
                    onRegisterClick = {}
                )
            }
        }
    }
}
