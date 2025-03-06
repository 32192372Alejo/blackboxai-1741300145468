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
                title = { Text("Resultado entrevista") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle close */ }) {
                        Icon(Icons.Default.Close, "Close")
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item {
                // Overall Performance Score
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
                            text = "Rendimiento general",
                            style = MaterialTheme.typography.titleLarge
                        )
                        
                        Text(
                            text = "4.8",
                            style = MaterialTheme.typography.displayLarge,
                            modifier = Modifier.padding(vertical = 16.dp)
                        )

                        // Rating distribution
                        RatingDistribution()
                    }
                }
            }

            item {
                // Performance Graph
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Calificación promedio",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = "4.8",
                            style = MaterialTheme.typography.headlineMedium
                        )
                        Text(
                            text = "Últimos 30 días +15%",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }

            item {
                // Comments Section
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Comentarios",
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )

                        FeedbackComment(
                            text = "Estás haciendo bien en mantener el contacto visual",
                            isPositive = true
                        )

                        FeedbackComment(
                            text = "Tu ritmo de habla es muy rápido, intenta hablar más lento",
                            isPositive = false
                        )

                        FeedbackComment(
                            text = "Estás haciendo bien en apartar la mirada de vez en cuando",
                            isPositive = true
                        )
                    }
                }
            }

            item {
                // Questions Section
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Preguntas",
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )

                        QuestionItem("Háblame de ti")
                        QuestionItem("¿Cuáles son tus fortalezas?")
                        QuestionItem("¿Cuáles son tus debilidades?")
                    }
                }
            }

            item {
                // Action Buttons
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Button(
                        onClick = { /* Handle retry */ },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Comenzar de nuevo")
                    }

                    OutlinedButton(
                        onClick = onNavigateToHome,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp)
                    ) {
                        Text("Volver al inicio")
                    }
                }
            }
        }
    }
}

@Composable
private fun RatingDistribution() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        RatingBar(rating = 5, percentage = 60)
        RatingBar(rating = 4, percentage = 25)
        RatingBar(rating = 3, percentage = 10)
        RatingBar(rating = 2, percentage = 3)
        RatingBar(rating = 1, percentage = 2)
    }
}

@Composable
private fun RatingBar(
    rating: Int,
    percentage: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$rating",
            modifier = Modifier.width(24.dp),
            style = MaterialTheme.typography.bodyMedium
        )
        LinearProgressIndicator(
            progress = percentage / 100f,
            modifier = Modifier
                .weight(1f)
                .height(8.dp)
        )
        Text(
            text = "$percentage%",
            modifier = Modifier.width(48.dp),
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.End
        )
    }
}

@Composable
private fun FeedbackComment(
    text: String,
    isPositive: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = if (isPositive) Icons.Default.CheckCircle else Icons.Default.Warning,
            contentDescription = null,
            tint = if (isPositive) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = text)
    }
}

@Composable
private fun QuestionItem(
    question: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = question)
    }
}
