package com.example.interviewsimulator.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.interviewsimulator.R

@Composable
fun WelcomeScreen(
    onNavigateToLogin: () -> Unit,
    onNavigateToRegister: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Interviewface",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(top = 48.dp)
        )
        
        Text(
            text = "Proyecta tu futuro laboral\ncon el uso de nuestro\nsimulador de entrevistas",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 24.dp)
        )

        // Interview sample images
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(3) { index ->
                Card(
                    modifier = Modifier
                        .size(width = 160.dp, height = 120.dp)
                ) {
                    Image(
                        painter = painterResource(id = when (index) {
                            0 -> R.drawable.interview_sample_1
                            1 -> R.drawable.interview_sample_2
                            else -> R.drawable.interview_sample_3
                        }),
                        contentDescription = "Interview sample ${index + 1}"
                    )
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onNavigateToLogin,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            Text("Iniciar sesión")
        }

        OutlinedButton(
            onClick = onNavigateToRegister,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrarse")
        }

        Text(
            text = "Con este simulador podrás practicar tus habilidades de\n" +
                  "entrevistado y mejorar la selección de candidatos\n" +
                  "para tu empresa",
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 24.dp)
        )
    }
}
