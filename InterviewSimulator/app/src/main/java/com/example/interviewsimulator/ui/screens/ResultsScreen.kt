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
fun ResultsScreen(
    onNavigateToHome: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Resultados") },
                navigationIcon = {
                    IconButton(onClick = onNavigateToHome) {
                        Icon(Icons.Default.Close, "Close")
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Score Section
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Puntuación Total",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(
                            text = "85%",
                            style = MaterialTheme.typography.displayLarge,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = "¡Excelente desempeño!",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    }
                }
            }

            // Detailed Results
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Detalles por categoría",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    ResultCategory(
                        title = "Comunicación",
                        score = 90,
                        icon = Icons.Default.Chat
                    )
                    ResultCategory(
                        title = "Conocimiento Técnico",
                        score = 85,
                        icon = Icons.Default.Code
                    )
                    ResultCategory(
                        title = "Resolución de Problemas",
                        score = 80,
                        icon = Icons.Default.Psychology
                    )
                    ResultCategory(
                        title = "Experiencia Profesional",
                        score = 85,
                        icon = Icons.Default.Work
                    )
                }
            }

            // Feedback Section
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Retroalimentación",
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        Text(
                            text = "• Excelente manejo de conceptos técnicos\n" +
                                  "• Buena claridad en las respuestas\n" +
                                  "• Podría mejorar en ejemplos prácticos\n" +
                                  "• Mantiene buen contacto visual",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }

            // Action Buttons
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = { /* Handle retry */ },
                        modifier = Modifier.weight(1f).padding(end = 8.dp)
                    ) {
                        Text("Intentar de nuevo")
                    }
                    Button(
                        onClick = onNavigateToHome,
                        modifier = Modifier.weight(1f).padding(start = 8.dp)
                    ) {
                        Text("Finalizar")
                    }
                }
            }
        }
    }
}

@Composable
private fun ResultCategory(
    title: String,
    score: Int,
    icon: ImageVector
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(24.dp)
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge
            )
            LinearProgressIndicator(
                progress = score / 100f,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
            )
        }
        Text(
            text = "$score%",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary
        )
    }
}
