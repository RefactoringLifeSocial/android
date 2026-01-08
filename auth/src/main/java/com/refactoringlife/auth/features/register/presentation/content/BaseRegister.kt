package com.refactoringlife.auth.features.register.presentation.content

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.refactoringlife.auth.R
import com.refactoringlife.auth.features.register.domain.state.RegisterState
import com.refactoringlife.auth.features.register.presentation.viewmodel.RegisterViewModel
import com.refactoringlife.auth.utils.theme.GrisHuellas
import kotlinx.coroutines.launch

@Composable
fun BaseRegister(
    back: () -> Unit,
    centerContent: @Composable () -> Unit,
    state: RegisterState,
    viewModel: RegisterViewModel
) {
    val scroll = rememberScrollState()
    val scope = rememberCoroutineScope()
    val pickMedia =
        rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
            scope.launch {
                viewModel.updateState(reducer = { state.copy(image = uri) })
            }
        }
    val painter = if (state.image != null) {
        rememberAsyncImagePainter(model = state.image)
    } else {
        painterResource(id = R.drawable.img_add_image_register)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White)
            .verticalScroll(scroll)
            .imePadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BackIcon(
            onBack = { back() },
            width = 30.dp,
            height = 30.dp,
            image = R.drawable.back,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 16.dp, top = 16.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))

        TextCustom(
            title = stringResource(id = R.string.register_title_),
            fontSize = 26.sp,
            color = Color.Black,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))
        Surface(
            modifier = Modifier.size(120.dp),
            shape = CircleShape,
            color = Color.White
        ) {
            Image(
                painter = painter,
                contentDescription = "profile image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
                    .clickable{
                        pickMedia.launch(
                            PickVisualMediaRequest(
                                ActivityResultContracts.PickVisualMedia.ImageOnly)
                        )
                    }

            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.register_type_image),
            fontSize = 12.sp,
            color = GrisHuellas,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(20.dp))
        centerContent()
    }
}
