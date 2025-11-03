package com.refactoringlife.auth.features.forgotpassword.presentation.composables

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.refactoringlife.auth.R
import com.refactoringlife.auth.features.register.presentation.theme.purpleLight
import kotlinx.coroutines.delay

private const val CODE_LENGTH = 6
private const val RESEND_TIME_SECONDS = 60

@Composable
fun CodeInputComponent(
    onCodeChanged: (String) -> Unit,
    onResendClicked: () -> Unit = {}
) {
    var codeChars by remember { mutableStateOf(CharArray(CODE_LENGTH) { ' ' }) }
    var focusedIndex by remember { mutableIntStateOf(0) }
    var timeLeft by remember { mutableIntStateOf(RESEND_TIME_SECONDS) }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusRequesters = remember { List(CODE_LENGTH) { FocusRequester() } }

    LaunchedEffect(timeLeft) {
        if (timeLeft > 0) {
            delay(1000L)
            timeLeft--
        }
    }

    LaunchedEffect(Unit) {
        focusRequesters[0].requestFocus()
        keyboardController?.show()
    }

    LaunchedEffect(codeChars.joinToString("").trim().length) {
        val fullCode = codeChars.joinToString("").trim()
        onCodeChanged(fullCode)
    }

    val updateChar: (Int, Char) -> Unit = { index, char ->
        codeChars = codeChars.copyOf().apply {
            this[index] = char
        }

        if (char != ' ' && index < CODE_LENGTH - 1) {
            focusedIndex = index + 1
            focusRequesters[index + 1].requestFocus()
        }
    }

    val deleteChar: (Int) -> Unit = { index ->
        codeChars = codeChars.copyOf().apply {
            this[index] = ' '
        }
        if (index > 0) {
            focusedIndex = index - 1
            focusRequesters[index - 1].requestFocus()
        }
    }

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
        Spacer(modifier = Modifier.height(30.dp))

        if (timeLeft > 0) {
            Text(
                text = stringResource(id = R.string.resend_code_validation),
                fontSize = 12.sp,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
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
            Text(
                text = stringResource(id = R.string.resend_code),
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
