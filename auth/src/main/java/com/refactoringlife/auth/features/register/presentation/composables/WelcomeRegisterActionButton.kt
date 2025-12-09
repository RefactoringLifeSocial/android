package com.refactoringlife.auth.features.register.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.refactoringlife.auth.R


@Composable
fun WelcomeRegisterActionButton(
    onUserRegisterClick: () -> Unit ,
    onFoundationRegisterClick: () -> Unit
) {
    Row(modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween)
    {
        Image(
            painter = painterResource(id = R.drawable.button_user_huella),
            contentDescription = "Google",
            modifier = Modifier
                .height(167.dp)
                .width(153.dp)
                .clickable { onUserRegisterClick() }
        )
        Image(
            painter = painterResource(id = R.drawable.button_fundation_huella),
            contentDescription = "Google",
            modifier = Modifier
                .height(167.dp)
                .width(153.dp)
                .clickable { onFoundationRegisterClick() }
        )
    }

}
