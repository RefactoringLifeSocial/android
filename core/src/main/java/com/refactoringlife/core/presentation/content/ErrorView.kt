package com.refactoringlife.core.presentation.content

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
import com.refactoringlife.core.presentation.theme.blueDark
import com.refactoringlife.core.presentation.utils.Constants

@Composable
fun ErrorView() {

    BaseScreen(
        topContent = {
            TextCustom(
                title = stringResource(id = R.string.error_title_server),
                fontSize = 32.sp,
                color = Color.Black,
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.Center,
                modifier = Modifier.testTag(Constants.ERROR_TITLE)
            )
            Spacer(modifier = Modifier.height(80.dp))
            ImageCustom(
                imageResId = R.drawable.close,
                contentDescription = "",
                width = 100.dp,
                height = 100.dp,
                modifier = Modifier.testTag(Constants.ERROR_IMAGE)
            )
        },
        bottomContent = {
            TextCustom(
                title = stringResource(id = R.string.error_communication_message),
                fontSize = 15.sp,
                color = blueDark,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                modifier = Modifier.testTag(Constants.ERROR_COMMUNICATION)
            )
        }
    )
}