package com.refactoringlife.core.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
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
fun NotConnectionScreen(
    onRetry: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(70.dp))
        Title()
        Spacer(modifier = Modifier.height(150.dp))
        NotConnectionImage()
        Spacer(modifier = Modifier.height(40.dp))
        TitleBottom(onRetry = {onRetry()})
    }
}

@Composable
private fun TitleBottom(
    onRetry: () -> Unit
) {
    Text(
        text = "Reintentar",
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        color = Color.Black,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .wrapContentWidth()
            .testTag(Constants.NOT_CONNECTION_RETRY)
            .clickable { onRetry() }
    )
}

@Composable
private fun NotConnectionImage() {
    Image(
        painter = painterResource(id = R.drawable.notconnection),
        contentDescription = "",
        modifier = Modifier.size(220.dp).testTag(Constants.NOT_CONNECTION_IMAGE)
    )
}

@Composable
private fun Title() {
    Text(
        text = "Ups! Detectamos que su conexion esta fallando",
        fontSize = 26.sp,
        fontWeight = FontWeight.Light,
        textAlign = TextAlign.Center,
        color = Color.Black,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 16.dp)
            .testTag(Constants.NOT_CONNECTION_TITLE)
    )
}

@Composable
@Preview(showBackground = true)
fun PreviewNotConnection() {
    NotConnectionScreen(onRetry = {})
}