package com.refactoringlife.auth.features.login.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.refactoringlife.auth.R
import com.refactoringlife.auth.features.login.presentation.theme.HuellaBlue
import com.refactoringlife.auth.features.login.presentation.theme.HuellaPurple
import com.refactoringlife.auth.utils.theme.BackgroudHuella

@Composable
fun ModalTYC(
    onDismiss: () -> Unit,
    onAccept: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    initialAcceptedState: Boolean = false
) {
    var isAccepted by remember(initialAcceptedState) { mutableStateOf(initialAcceptedState) }
    val scrollState = rememberScrollState()

    Dialog(
        onDismissRequest = onDismiss,
        DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true
        )
    ) {
        Surface(
            modifier = modifier
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
                .widthIn(max = 500.dp)
                .wrapContentHeight()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = stringResource(R.string.t_rminos_y_condiciones_y_pol_ticas_de_privacidad_de_huellas),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = HuellaPurple,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(370.dp)
                        .background(BackgroudHuella, RoundedCornerShape(8.dp))
                        .padding(12.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .verticalScroll(scrollState)
                    ) {
                        Text(
                            text = stringResource(R.string.terms_content),
                            fontSize = 14.sp,
                            lineHeight = 20.sp,
                            textAlign = TextAlign.Justify
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = isAccepted,
                        onCheckedChange = { isAccepted = it },
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = stringResource(R.string.acepto_los_terminos),
                        fontSize = 14.sp,
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = stringResource(R.string.aceptar),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = HuellaPurple,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onAccept(isAccepted)
                            onDismiss()
                        }
                        .padding(vertical = 10.dp),
                    textAlign = TextAlign.Center
                )

                Text(
                    text = stringResource(R.string.cancelar),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = HuellaBlue,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onDismiss() }
                        .padding(vertical = 10.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
