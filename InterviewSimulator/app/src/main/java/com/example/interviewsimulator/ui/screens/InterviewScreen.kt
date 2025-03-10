package com.example.interviewsimulator.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InterviewScreen(
    onFinishInterview: () -> Unit
) {
    var isRecording by remember { mutableStateOf(false) }
    var isVideoOn by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Entrevista en curso") },
                navigationIcon = {
                    IconButton(onClick = onFinishInterview) {
                        Icon(Icons.Default.Close, "Close Interview")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Video preview area
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Videocam,
                    contentDescription = "Video Preview",
                    modifier = Modifier.size(64.dp)
                )
            }

            // Controls
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                IconButton(
                    onClick = { isRecording = !isRecording }
                ) {
                    Icon(
                        imageVector = if (isRecording) Icons.Default.Stop else Icons.Default.Mic,
                        contentDescription = if (isRecording) "Stop Recording" else "Start Recording"
                    )
                }

                IconButton(
                    onClick = { isVideoOn = !isVideoOn }
                ) {
                    Icon(
                        imageVector = if (isVideoOn) Icons.Default.Videocam else Icons.Default.VideocamOff,
                        contentDescription = if (isVideoOn) "Turn Off Camera" else "Turn On Camera"
                    )
                }
            }

            // Question area
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Pregunta actual:",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "¿Cuál ha sido tu experiencia más desafiante y cómo la manejaste?",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }

            // Action buttons
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { /* Skip question */ },
                    modifier = Modifier.weight(1f).padding(end = 8.dp)
                ) {
                    Text("Saltar")
                }
                Button(
                    onClick = { /* Next question */ },
                    modifier = Modifier.weight(1f).padding(start = 8.dp)
                ) {
                    Text("Siguiente")
                }
            }
        }
    }
}
