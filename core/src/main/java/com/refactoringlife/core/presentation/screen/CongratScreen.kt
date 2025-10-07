package com.refactoringlife.core.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.refactoringlife.core.R
import com.refactoringlife.core.presentation.utils.Constants

@Composable
fun CongratsScreen(
    goToEmail : () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(160.dp))
            Title()
            Spacer(modifier = Modifier.height(120.dp))
            Check()
        }
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(bottom = 22.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalDivider(modifier = Modifier.padding(bottom = 22.dp, start = 16.dp, end = 16.dp))
            GoToEmail(goToEmail = {goToEmail()})
        }
    }

}

@Composable
private fun GoToEmail(
    goToEmail : () -> Unit
) {
    Text(
        text = "Ir al Email",
        textAlign = TextAlign.Center,
        fontSize = 15.sp,
        fontWeight = FontWeight.ExtraBold,
        color = Color(0xFF7353BA),
        modifier = Modifier
            .wrapContentWidth()
            .testTag(Constants.CONGRATS_GO_TO_EMAIL)
            .clickable {goToEmail()}
    )
}

@Composable
private fun Check() {
    Image(
        painter = painterResource(id = R.drawable.check),
        contentDescription = "check",
        modifier = Modifier.size(100.dp).testTag(Constants.CONGRATS_IMAGE)
    )
}

@Composable
private fun Title(
    title: String = "Tu contraseña fue actualizada de forma exitosa"
) {
    Text(
        text = title,
        textAlign = TextAlign.Center,
        fontSize = 32.sp,
        color = Color.Black,
        fontWeight = FontWeight.Light,
        modifier = Modifier.testTag(Constants.CONGRATS_TITLE)
    )
}

@Composable
@Preview(showBackground = true)
fun PreviewCongrats() {
    CongratsScreen(goToEmail = {})
}