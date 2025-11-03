package com.refactoringlife.auth.features.forgotpassword.presentation.composables

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
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
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.refactoringlife.auth.features.register.presentation.theme.grayLight
import com.refactoringlife.auth.features.register.presentation.theme.purpleLight
import com.refactoringlife.core.common.utils.Constants.EMPTY
import kotlinx.coroutines.delay

private const val CODE_LENGTH = 6
private const val RESEND_TIME_SECONDS = 60

@Composable
fun CodeInputComponent(
    onCodeChanged: (String) -> Unit,
    onResendClicked: () -> Unit = {}
) {
    // Array de caracteres individuales para cada campo
    var codeChars by remember { mutableStateOf(CharArray(CODE_LENGTH) { ' ' }) }
    var focusedIndex by remember { mutableIntStateOf(0) }
    var timeLeft by remember { mutableIntStateOf(RESEND_TIME_SECONDS) }
    val keyboardController = LocalSoftwareKeyboardController.current

    // Focus requester para cada campo
    val focusRequesters = remember { List(CODE_LENGTH) { FocusRequester() } }

    LaunchedEffect(timeLeft) {
        if (timeLeft > 0) {
            delay(1000L)
            timeLeft--
        }
    }

    // Al iniciar, enfocar el primer campo
    LaunchedEffect(Unit) {
        focusRequesters[0].requestFocus()
        keyboardController?.show()
    }

    // Actualizar el código completo cuando cambian los caracteres
    LaunchedEffect(codeChars.joinToString("").trim().length) {
        val fullCode = codeChars.joinToString("").trim()
        onCodeChanged(fullCode)
    }

    // Función para actualizar un carácter específico
    val updateChar: (Int, Char) -> Unit = { index, char ->
        codeChars = codeChars.copyOf().apply {
            this[index] = char
        }

        // Si escribimos un carácter y no es el último campo, mover al siguiente
        if (char != ' ' && index < CODE_LENGTH - 1) {
            focusedIndex = index + 1
            focusRequesters[index + 1].requestFocus()
        }
    }

    // Función para borrar un carácter específico
    val deleteChar: (Int) -> Unit = { index ->
        codeChars = codeChars.copyOf().apply {
            this[index] = ' '
        }
        // Si borramos y no es el primer campo, retroceder
        if (index > 0) {
            focusedIndex = index - 1
            focusRequesters[index - 1].requestFocus()
        }
    }

    // Función para manejar clicks en los slots
    val onSlotClick: (Int) -> Unit = { index ->
        focusedIndex = index
        focusRequesters[index].requestFocus()
        keyboardController?.show()
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Visualización del Código (6 campos independientes)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            repeat(CODE_LENGTH) { index ->
                CodeSlot(
                    char = codeChars[index],
                    isFocused = index == focusedIndex,
                    onCharChange = { char -> updateChar(index, char) },
                    onDelete = { deleteChar(index) },
                    onClick = { onSlotClick(index) },
                    focusRequester = focusRequesters[index],
                    modifier = Modifier
                )
            }
        }

        // Espaciador entre el código y el contador
        Spacer(modifier = Modifier.height(30.dp))

        // Reenviar Código y Contador
        if (timeLeft > 0) {
            // Estado de "Contador Activo"
            Text(
                text = "Reenviar código de validación",
                fontSize = 12.sp,
                color = Color.Black,
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
                text = "Reenviar código de validación",
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Text(
                text = "Reenviar Código",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = purpleLight,
                modifier = Modifier
                    .clickable {
                        onResendClicked()
                        timeLeft = RESEND_TIME_SECONDS
                        codeChars = CharArray(CODE_LENGTH) { ' ' }
                        focusedIndex = 0
                        focusRequesters[0].requestFocus()
                        keyboardController?.show()
                    }
                    .padding(top = 4.dp)
            )
        }
    }
}

// Composable para cada slot individual del código
@Composable
private fun CodeSlot(
    char: Char,
    isFocused: Boolean,
    onCharChange: (Char) -> Unit,
    onDelete: () -> Unit,
    onClick: () -> Unit,
    focusRequester: FocusRequester,
    modifier: Modifier = Modifier
) {
    val displayChar = if (char == ' ') "" else char.toString()
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .height(50.dp)
            .width(40.dp)
            .clickable(onClick = onClick)
    ) {
        // Campo de texto invisible pero funcional
        BasicTextField(
            value = TextFieldValue(
                text = displayChar,
                selection = TextRange(displayChar.length)
            ),
            onValueChange = { newValue ->
                val inputText = newValue.text.filter { it.isLetterOrDigit() }.uppercase()

                if (inputText.isNotEmpty()) {
                    // Si hay input, tomar el último carácter y actualizar
                    val newChar = inputText.last()
                    onCharChange(newChar)
                } else {
                    // Si está vacío, borrar este campo
                    onDelete()
                }
            },
            modifier = Modifier
                .focusRequester(focusRequester)
                .size(width = 40.dp, height = 40.dp),
            textStyle = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                autoCorrect = false
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                }
            ),
            cursorBrush = SolidColor(Color.Transparent),
            singleLine = true,
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier.size(width = 40.dp, height = 40.dp),
                    contentAlignment = Alignment.Center
                ) {
                    // Mostrar el carácter visualmente
                    Text(
                        text = displayChar.ifEmpty { EMPTY },
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            textAlign = TextAlign.Center
                        )
                    )
                    innerTextField()
                }
            }
        )

        // Línea inferior
        Spacer(modifier = Modifier.height(6.dp))
        Box(
            modifier = Modifier
                .width(40.dp)
                .height(2.dp)
                .background(
                    when {
                        isFocused -> purpleLight
                        char != ' ' -> Color.Black
                        else -> grayLight
                    }
                )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCodeInputComponent() {
    CodeInputComponent(onCodeChanged = {})
}