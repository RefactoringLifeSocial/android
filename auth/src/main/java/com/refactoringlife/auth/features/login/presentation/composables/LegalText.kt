package com.refactoringlife.auth.features.login.presentation.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.refactoringlife.auth.R
import com.refactoringlife.auth.features.login.presentation.theme.GrayLight
import com.refactoringlife.auth.features.login.presentation.theme.HuellaPurple


@Composable
fun LegalText(
    onTermsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Text(
        buildAnnotatedString {
            append(stringResource(R.string.al_continuar_aceptas_los))
            pushStringAnnotation(tag = stringResource(R.string.terms), annotation = stringResource(R.string.terms))
            withStyle(style = SpanStyle(color = HuellaPurple)) {
                append(stringResource(R.string.t_rminos_y_condiciones_y_pol_ticas_de_privacidad_de_huellas))
            }
            pop()
        },
        style = TextStyle(fontSize = 12.sp, color = GrayLight),
        textAlign = TextAlign.Center,
        modifier = modifier
            .fillMaxWidth()
            .clickable { onTermsClick() }
    )
}