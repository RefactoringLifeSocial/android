package com.refactoringlife.auth.features.forgotpassword.presentation.composables

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.refactoringlife.auth.R
import com.refactoringlife.auth.features.register.presentation.theme.grayLight
import com.refactoringlife.auth.features.register.presentation.theme.purpleLight
import com.refactoringlife.core.common.utils.Constants.EMPTY
import kotlinx.coroutines.delay

private const val CODE_LENGTH = 6
private const val RESEND_TIME_SECONDS = 60

@Composable
fun CodeInputComponent(
    modifier: Modifier = Modifier,
    onCodeChanged: (String) -> Unit,
    onResendClicked: () -> Unit = {}
) {
    // Estado interno para el código (usando TextFieldValue para controlar la selección/cursor)
    var codeValue by remember { mutableStateOf(TextFieldValue(EMPTY)) }

    // Estado para el contador de tiempo
    var timeLeft by remember { mutableIntStateOf(RESEND_TIME_SECONDS) }

    // Estado para el FocusRequester
    val focusRequester = remember { FocusRequester() }

    // --- Lógica del Contador de Tiempo ---
    LaunchedEffect(timeLeft) {
        if (timeLeft > 0) {
            delay(1000L)
            timeLeft--
        }
    }

    // Al iniciar, forzar el foco en el campo (para abrir el teclado)
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    // Función para manejar los cambios en el input
    val onValueChange: (TextFieldValue) -> Unit = { newValue ->
        val text = newValue.text.filter { it.isDigit() }.take(CODE_LENGTH)

        // Actualiza el estado
        codeValue = newValue.copy(
            text = text,
            selection = TextRange(text.length) // Mueve el cursor al final
        )

        // Notifica al Composable padre
        onCodeChanged(text)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Campo de texto invisible que captura todos los inputs
        BasicTextField(
            value = codeValue,
            onValueChange = onValueChange,
            modifier = Modifier
                .size(0.dp) // Lo hacemos invisible
                .focusRequester(focusRequester),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword)
        )

        // Visualización del Código (6 cajas)
        CodeDisplay(code = codeValue.text)

        // Espaciador entre el código y el contador
        Spacer(modifier = Modifier.height(30.dp))

        // Reenviar Código y Contador
        if (timeLeft > 0) {
            // Estado de "Contador Activo"
            Text(
                text = "Reenviar código de validación", //stringResource(id = R.string.resend_code_in)
                fontSize = 13.sp,
                color = grayLight,
                textAlign = TextAlign.Center
            )

            // Contador numérico animado
            AnimatedContent(
                targetState = timeLeft,
                transitionSpec = {
                    slideIntoContainer(
                        towards = AnimatedContentTransitionScope.SlideDirection.Down,
                        animationSpec = tween(durationMillis = 300)
                    ).togetherWith(
                        slideOutOfContainer(
                            towards = AnimatedContentTransitionScope.SlideDirection.Down,
                            animationSpec = tween(durationMillis = 300)
                        )
                    )
                },
                label = "CounterAnimation"
            ) { targetCount ->
                Text(
                    text = targetCount.toString().padStart(2, '0'),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        } else {
            // Estado de "Reenviar Disponible"
            Text(
                text = "Reenviar Código", //stringResource(id = R.string.resend_code), //
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = purpleLight,
                modifier = Modifier
                    .clickable {
                        onResendClicked()
                        timeLeft = RESEND_TIME_SECONDS // Reinicia el contador
                    }
            )
        }
    }
}

// Composable interno para dibujar las 6 cajas
@Composable
private fun CodeDisplay(code: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        repeat(CODE_LENGTH) { index ->
            val char = code.getOrElse(index) { ' ' }
            val isFocused = index == code.length

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Transparent)
                    .border(
                        width = 2.dp,
                        color = if (isFocused) purpleLight else grayLight,
                        shape = RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = char.toString(),
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center,
                        color = Color.Black
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCodeInputComponent() {
    CodeInputComponent(onCodeChanged = {})
}
