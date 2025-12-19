package com.refactoringlife.adoption.features.welcome.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Screen3() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Screen 3",
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text("Esta es la pantalla 3 de prueba")
    }
}

// Wrapper con navegación
@Composable
fun Screen3WithNavigation(
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Screen 3",
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text("Esta es la pantalla 3 de prueba")

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = onBack) {
            Text("Volver")
        }
    }
}