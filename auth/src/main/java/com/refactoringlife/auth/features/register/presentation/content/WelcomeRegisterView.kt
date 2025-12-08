package com.refactoringlife.auth.features.register.presentation.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.refactoringlife.auth.R
import com.refactoringlife.auth.features.register.presentation.composables.WelcomeRegisterActionButton
import com.refactoringlife.auth.utils.theme.BackgroudHuella
import com.refactoringlife.auth.utils.theme.GrisHuellas


@Composable
@Preview(showBackground = true)
fun WelcomeRegisterView() {
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroudHuella)
            .verticalScroll(scrollState)
            .navigationBarsPadding(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(),
            painter = painterResource(id = R.drawable.rectangle_192),
            contentDescription = "Background",
            contentScale = ContentScale.FillWidth,
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp)
        )
        {
            TitleWelcomeRegister()
            Spacer(modifier = Modifier.height(30.dp))
            WelcomeRegisterDescription()
            Spacer(modifier = Modifier.height(30.dp))
            WelcomeRegisterActionButton()
        }
        WelcomeRegisterDescriptionOfButtons(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(start = 30.dp, end = 30.dp, bottom = 30.dp)
        )
    }
}


@Composable
fun WelcomeRegisterDescriptionOfButtons(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "*Sé un \"Usuario\" si deseas reportar, adoptar, dar hogar temporal o ayudar económicamente a una mascota que lo necesita.",
            color = GrisHuellas,
            fontSize = 12.sp,
            textAlign = TextAlign.Start,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "*Sé un \"Fundador\" si deseas tener mayor visibilidad para tu fundación y llegar a más usuarios dentro de Huella.",
            color = GrisHuellas,
            fontSize = 12.sp,
            textAlign = TextAlign.Start
        )
    }
}


@Composable
fun TitleWelcomeRegister() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Text(
            text = stringResource(id = R.string.mesage_welcome_register),
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 4.dp)
        )
        Icon(
            imageVector = Icons.Default.Pets,
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }

}


@Composable
fun WelcomeRegisterDescription() {
    Text(
        text = stringResource(id = R.string.mesage_welcome_register_description),
        color = Color.White,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)
    )
}

