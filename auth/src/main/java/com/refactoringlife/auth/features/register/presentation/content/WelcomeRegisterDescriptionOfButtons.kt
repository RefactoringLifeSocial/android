package com.refactoringlife.auth.features.register.presentation.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.refactoringlife.auth.R
import com.refactoringlife.auth.utils.theme.GrisHuellas

@Composable
fun WelcomeRegisterDescriptionOfButtons(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(id = R.string.description_button_user),
            color = GrisHuellas,
            fontSize = 12.sp,
            textAlign = TextAlign.Start,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(id = R.string.description_button_foundation),
            color = GrisHuellas,
            fontSize = 12.sp,
            textAlign = TextAlign.Start
        )
    }
}
