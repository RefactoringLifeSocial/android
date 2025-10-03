package com.refactoringlife.socialpets.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.refactoringlife.core.common.utils.Constants
import com.refactoringlife.socialpets.R
import com.refactoringlife.socialpets.ui.theme.Gray80

@Composable
fun Loading(action: () -> Unit){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray80)
        ,
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                modifier = Modifier
                    .size(60.dp)
                    .clickable(onClick = action)
                    .testTag(Constants.LOADING_ICON_TAG)
                ,
                painter = painterResource(id = R.drawable.loading_icon),
                contentDescription = null,
                contentScale = ContentScale.Fit
            )
        }
    }
}
