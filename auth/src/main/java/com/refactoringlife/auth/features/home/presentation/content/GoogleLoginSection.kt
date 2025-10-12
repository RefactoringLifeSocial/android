package com.refactoringlife.auth.features.home.presentation.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.refactoringlife.auth.R
import com.refactoringlife.auth.utils.TAG_GOOGLE_TEXT
import com.refactoringlife.auth.utils.TAG_LOGIN_BUTTON

@Composable
fun GoogleLoginSection(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier
            .testTag(TAG_LOGIN_BUTTON)
            .clickable {
            onClick()
        }
    ) {
        Image(
            painter = painterResource(id = R.drawable.login_with_google_icon),
            contentDescription = stringResource(id = R.string.login_with_google),
            modifier = Modifier.size(120.dp)
        )

        Text(
            text = stringResource(id = R.string.login_with_google),
            color = Color.Blue,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            modifier = Modifier.testTag(TAG_GOOGLE_TEXT)
        )
    }
}