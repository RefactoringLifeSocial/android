package com.refactoringlife.core.common.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.refactoringlife.core.R
import com.refactoringlife.core.common.ui.theme.Gray80
import com.refactoringlife.core.common.utils.Constants

@Composable
fun Loading(){
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.loading_trail)
    )

    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray80)
        ,
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            LottieAnimation(
                composition = composition,
                progress = { progress },
                modifier = Modifier
                    .size(150.dp)
                    .testTag(Constants.LOADING_TAG)
            )
        }
    }
}
