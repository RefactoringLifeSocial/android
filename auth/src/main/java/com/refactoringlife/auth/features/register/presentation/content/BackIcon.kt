package com.refactoringlife.auth.features.register.presentation.content

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.refactoringlife.auth.R

@Composable
fun BackIcon(
    onBack: () -> Unit,
    width: Dp,
    height: Dp,
    image: Int,
    modifier: Modifier
) {
    IconButton(
        onClick = { onBack() },
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(id = image),
            contentDescription = "",
            modifier = Modifier.size(height = height, width = width)
        )
    }

}

@Composable
@Preview(showBackground = true)
fun PreviewBackIcon() {
    BackIcon(
        onBack = {},
        width = 30.dp,
        height = 30.dp,
        image = R.drawable.back,
        modifier = Modifier
    )
}