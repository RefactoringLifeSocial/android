package com.refactoringlife.auth.features.onboarding.presentation.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.refactoringlife.auth.R

@Composable
fun OnboardingImageCollage(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier
            .width(346.dp)
            .height(415.dp)
    ) {
        Box(
            modifier = modifier
                .width(346.dp)
                .height(227.dp)
        ) {
            //card3
            Card(
                modifier = Modifier
                    .width(134.dp)
                    .height(201.dp)
                    .offset(x = (211).dp, y = 24.dp),
                shape = RoundedCornerShape(20.dp),
                border = BorderStroke(1.dp, Color.LightGray),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.image3_onboarding),
                    contentDescription = "Card Image Start",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            //card 2
            Card(
                modifier = Modifier
                    .width(134.dp)
                    .height(201.dp)
                    .offset(x = 105.dp, y = 1.dp),
                shape = RoundedCornerShape(20.dp),
                border = BorderStroke(1.dp, Color.LightGray),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.image2_onboarding),
                    contentDescription = "Card Image Start",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            //card 1
            Card(
                modifier = Modifier
                    .width(134.dp)
                    .height(201.dp)
                    .offset(x = (1).dp, y = 24.dp),
                shape = RoundedCornerShape(20.dp),
                border = BorderStroke(1.dp, Color.LightGray),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.image1_onboarding),
                    contentDescription = "Card Image Start",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        Box(
            modifier = modifier
                .width(346.dp)
                .height(227.dp)
                .offset(y = (-18).dp),
            contentAlignment = Alignment.TopCenter
        ) {
            OnboardingLogoWithText()
        }
    }
}

@Composable
@Preview(showBackground = true)
fun OnboardingImageCollagePreview() {
    OnboardingImageCollage()
}
