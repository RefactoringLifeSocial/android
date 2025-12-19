package com.refactoringlife.adoption.features.welcome.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Screen2() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Screen 2",
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text("Esta es la pantalla 2 de prueba")
    }
}

// Wrapper con navegación
@Composable
fun Screen2WithNavigation(
    id: String,
    onNavigateToScreen3: () -> Unit,
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
            text = "Screen 2",
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "ID recibido: $id",
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text("Esta es la pantalla 2 de prueba")

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = onNavigateToScreen3) {
            Text("Ir a Screen 3")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onBack) {
            Text("Volver")
        }
    }
}