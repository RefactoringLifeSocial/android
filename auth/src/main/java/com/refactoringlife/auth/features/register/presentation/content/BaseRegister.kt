package com.refactoringlife.auth.features.register.presentation.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.refactoringlife.auth.R
import com.refactoringlife.auth.utils.theme.GrisHuellas

@Composable
fun BaseRegister(
    back: () -> Unit,
    centerContent: @Composable () -> Unit
) {
    val scroll = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White)
            .verticalScroll(state = scroll),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BackIcon(
            onBack = { back() },
            width = 30.dp,
            height = 30.dp,
            image = R.drawable.back,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 16.dp, top = 16.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))

        TextCustom(
            title = stringResource(id = R.string.register_title_),
            fontSize = 26.sp,
            color = Color.Black,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(R.drawable.img_add_image_register),
            contentDescription = "logo",
            modifier = Modifier.size(113.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.register_type_image),
            fontSize = 12.sp,
            color = GrisHuellas,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(20.dp))
        centerContent()
    }
}

@Composable
@Preview(showBackground = true)
fun BaseRegisterPreview(){
    BaseRegister(
        back = {},
        centerContent = {}
    )
}
