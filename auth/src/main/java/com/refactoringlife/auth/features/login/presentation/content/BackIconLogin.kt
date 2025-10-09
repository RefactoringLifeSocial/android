package com.refactoringlife.auth.features.login.presentation.content

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.res.stringResource
import com.refactoringlife.core.R


@Composable
fun BackIconLogin(
    onBack: () -> Unit,
    image: Int,
    width: Dp,
    height: Dp,
    modifier: Modifier
) {
    IconButton(
        onClick = { onBack() },
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(id = image),
            contentDescription = stringResource(R.string.volver),
            tint = Color.Black,
            modifier = Modifier.size(height = height, width = width)
        )
    }
}
