package com.refactoringlife.core.presentation.content

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.refactoringlife.core.R
import com.refactoringlife.core.presentation.theme.actionPurple
import com.refactoringlife.core.presentation.utils.Constants

@Composable
fun CongratsView(
    goToEmail: () -> Unit
) {
    BaseScreen(
        topContent = {
            TextCustom(
                title = stringResource(id = R.string.congrats_title_password_updated),
                fontSize = 32.sp,
                color = Color.Black,
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .testTag(Constants.CONGRATS_TITLE)
                    .padding(horizontal = 24.dp)
            )
            Spacer(modifier = Modifier.height(120.dp))
            ImageCustom(
                imageResId = R.drawable.check,
                contentDescription = "",
                width = 100.dp,
                height = 100.dp,
                modifier = Modifier.testTag(Constants.CONGRATS_IMAGE)
            )
        },
        bottomContent = {
            TextCustom(
                title = stringResource(id = R.string.congrats_go_to_email),
                fontSize = 15.sp,
                fontWeight = FontWeight.ExtraBold,
                color = actionPurple,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .clickable { goToEmail() }
                    .testTag(Constants.CONGRATS_GO_TO_EMAIL)
            )
        }
    )
}