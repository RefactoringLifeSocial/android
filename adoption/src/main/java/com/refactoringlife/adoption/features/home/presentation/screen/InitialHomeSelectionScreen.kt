package com.refactoringlife.adoption.features.home.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.refactoringlife.adoption.R
import com.refactoringlife.adoption.features.home.domain.blocs.InitialHomeEvent
import com.refactoringlife.adoption.features.home.presentation.composables.InitialHomeRadioButton
import com.refactoringlife.adoption.features.home.presentation.viewmodel.InitialHomeViewModel
import com.refactoringlife.adoption.utils.InitialHomeOptions
import com.refactoringlife.core.presentation.theme.HuellaPurple

@Composable
fun InitialHomeSelectionScreen(
    viewModel: InitialHomeViewModel
){
    // Observamos el estado del ViewModel
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(40.dp))

        Image(
            painter = painterResource(id = R.drawable.huellaicon),
            contentDescription = stringResource(R.string.welcome_logo),
            modifier = Modifier.size(120.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.huellatext ),
            contentDescription = stringResource(R.string.welcome_logo_text),
            modifier = Modifier.size(120.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = stringResource(R.string.welcome_title),
            color = Color.Black,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Normal,
            lineHeight = 26.sp
        )

        Spacer(modifier = Modifier.height(40.dp))

        InitialHomeRadioButton(
            text = stringResource(R.string.welcome_option_gallery),
            selected = state.selectedOption == InitialHomeOptions.GALLERY,
            onClick = {
                viewModel.sendEvent(InitialHomeEvent.SelectOption(InitialHomeOptions.GALLERY))
            }
        )

        InitialHomeRadioButton(
            text = stringResource(R.string.welcome_option_foundations),
            selected = state.selectedOption == InitialHomeOptions.FOUNDATIONS,
            onClick = {
                viewModel.sendEvent(InitialHomeEvent.SelectOption(InitialHomeOptions.FOUNDATIONS))
            }
        )

        InitialHomeRadioButton(
            text = stringResource(R.string.welcome_option_report),
            selected = state.selectedOption == InitialHomeOptions.REPORT,
            onClick = {
                viewModel.sendEvent(InitialHomeEvent.SelectOption(InitialHomeOptions.REPORT))
            }
        )

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = {
                viewModel.sendEvent(InitialHomeEvent.Accept)
            },
            shape = RoundedCornerShape(50),
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(50),
                    clip = false
                ),
            colors = ButtonDefaults.buttonColors(
                containerColor = HuellaPurple
            )
        ) {
            Text(stringResource(R.string.welcome_accept))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(R.string.welcome_skip),
            color = HuellaPurple,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier
                .clickable {
                    viewModel.sendEvent(InitialHomeEvent.Skip)
                }
                .padding(8.dp),
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
    }
}