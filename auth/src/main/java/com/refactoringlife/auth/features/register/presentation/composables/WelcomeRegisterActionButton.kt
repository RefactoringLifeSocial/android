package com.refactoringlife.auth.features.register.presentation.composables

import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.refactoringlife.auth.R


@Composable
fun WelcomeRegisterActionButton() {
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
                .clickable { }
        )
        Image(
            painter = painterResource(id = R.drawable.button_fundation_huella),
            contentDescription = "Google",
            modifier = Modifier
                .height(167.dp)
                .width(153.dp)
                .clickable { }
        )
    }

}

@Composable
fun RegisterActionButton(){

}

@Composable
@Preview(showBackground = true)
fun WelcomeRegisterActionButtonPreview()
{
    WelcomeRegisterActionButton()
}
