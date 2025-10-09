package com.refactoringlife.core.presentation.content

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.refactoringlife.core.R
import com.refactoringlife.core.presentation.utils.Constants

@Composable
fun NotConnectionView(
    onRetry: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(70.dp))
        TextCustom(
            title = stringResource(id = R.string.error_title_no_connection),
            fontSize = 26.sp,
            color = Color.Black,
            fontWeight = FontWeight.Light,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .testTag(Constants.NOT_CONNECTION_TITLE)
        )
        Spacer(modifier = Modifier.height(150.dp))
        ImageCustom(
            imageResId = R.drawable.notconnection,
            contentDescription = "",
            width = 220.dp,
            height = 220.dp,
            modifier = Modifier.testTag(Constants.NOT_CONNECTION_IMAGE)
        )
        Spacer(modifier = Modifier.height(40.dp))
        TextCustom(
            title = stringResource(id = R.string.no_connection_retry_button),
            fontSize = 16.sp,
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .wrapContentWidth()
                .clickable { onRetry() }
                .testTag(Constants.NOT_CONNECTION_RETRY)
        )
    }
}