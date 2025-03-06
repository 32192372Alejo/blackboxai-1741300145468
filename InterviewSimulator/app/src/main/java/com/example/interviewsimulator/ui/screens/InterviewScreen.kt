package com.example.interviewsimulator.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InterviewScreen(
    onFinishInterview: () -> Unit
) {
    var currentStep by remember { mutableStateOf(1) }
    var isRecording by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Entrevista en progreso") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back navigation */ }) {
                        Icon(Icons.Default.Close, "Close")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Progress indicator
            LinearProgressIndicator(
                progress = currentStep / 5f,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )

            Text(
                text = "Etapa $currentStep",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            // Question section
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Pregunta",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = getCurrentQuestion(currentStep),
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
            }

            // Recording controls
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { /* Toggle camera */ }
                ) {
                    Icon(Icons.Default.Videocam, "Camera")
                }

                FloatingActionButton(
                    onClick = { isRecording = !isRecording }
                ) {
                    Icon(
                        if (isRecording) Icons.Default.Stop else Icons.Default.Mic,
                        if (isRecording) "Stop Recording" else "Start Recording"
                    )
                }

                IconButton(
                    onClick = { /* Toggle settings */ }
                ) {
                    Icon(Icons.Default.Settings, "Settings")
                }
            }

            // Response options
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Button(
                    onClick = { /* Handle text response */ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Responder en texto")
                }

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = { /* Handle video response */ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Responder en video")
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            // Navigation buttons
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextButton(
                    onClick = { if (currentStep > 1) currentStep-- }
                ) {
                    Text("Anterior")
                }

                Button(
                    onClick = {
                        if (currentStep < 5) currentStep++
                        else onFinishInterview()
                    }
                ) {
                    Text(if (currentStep < 5) "Continuar" else "Finalizar")
                }
            }
        }
    }
}

private fun getCurrentQuestion(step: Int): String {
    return when (step) {
        1 -> "¿Cuál es tu experiencia con el desarrollo de aplicaciones móviles?"
        2 -> "¿Cómo manejarías un conflicto en el equipo?"
        3 -> "Describe un proyecto desafiante en el que hayas trabajado"
        4 -> "¿Cuáles son tus objetivos profesionales a largo plazo?"
        5 -> "¿Por qué te interesa trabajar en nuestra empresa?"
        else -> ""
    }
}
