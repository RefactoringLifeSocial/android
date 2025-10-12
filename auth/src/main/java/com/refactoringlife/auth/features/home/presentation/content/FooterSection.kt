package com.refactoringlife.auth.features.home.presentation.content


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.refactoringlife.auth.R

@Composable
fun FooterSection(goToSupport: () -> Unit) {
    Text(
        text = stringResource(id = R.string.contact_support),
        textAlign = TextAlign.Center,
        fontSize = 14.sp,
        color = Color.Black,
        modifier = Modifier
            .padding(bottom = 24.dp)
            .clickable { goToSupport() }
    )
}
