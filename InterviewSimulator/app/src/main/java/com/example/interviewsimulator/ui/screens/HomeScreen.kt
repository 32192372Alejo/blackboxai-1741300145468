package com.example.interviewsimulator.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

data class InterviewType(
    val title: String,
    val description: String,
    val icon: ImageVector
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToInterview: () -> Unit,
    onNavigateToProfile: () -> Unit,
    onNavigateToSettings: () -> Unit
) {
    var selectedDifficulty by remember { mutableStateOf("Normal") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Entrevistas") },
                actions = {
                    IconButton(onClick = onNavigateToProfile) {
                        Icon(Icons.Default.Person, "Profile")
                    }
                    IconButton(onClick = onNavigateToSettings) {
                        Icon(Icons.Default.Settings, "Settings")
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
            Text(
                text = "Seleccione el tipo de entrevista\nque desea realizar:",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            ) {
                items(interviewTypes) { interviewType ->
                    InterviewTypeCard(
                        type = interviewType,
                        onClick = onNavigateToInterview
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Nivel de dificultad",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    DifficultyOptions(
                        selectedDifficulty = selectedDifficulty,
                        onDifficultySelected = { selectedDifficulty = it }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun InterviewTypeCard(
    type: InterviewType,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = type.icon,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = type.title,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = type.description,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
private fun DifficultyOptions(
    selectedDifficulty: String,
    onDifficultySelected: (String) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        DifficultyOption(
            text = "Fácil",
            selected = selectedDifficulty == "Fácil",
            onClick = { onDifficultySelected("Fácil") }
        )
        DifficultyOption(
            text = "Normal",
            selected = selectedDifficulty == "Normal",
            onClick = { onDifficultySelected("Normal") }
        )
        DifficultyOption(
            text = "Difícil",
            selected = selectedDifficulty == "Difícil",
            onClick = { onDifficultySelected("Difícil") }
        )
    }
}

@Composable
private fun DifficultyOption(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
            contentColor = if (selected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface
        )
    ) {
        Text(text)
    }
}

private val interviewTypes = listOf(
    InterviewType(
        "Práctica técnica",
        "Preguntas sobre código, diseño y arquitectura",
        Icons.Default.Code
    ),
    InterviewType(
        "Ventas",
        "Preguntas de ventas y escenarios de rol",
        Icons.Default.AttachMoney
    ),
    InterviewType(
        "Gerente de producto",
        "Preguntas sobre productos y estrategia",
        Icons.Default.Business
    ),
    InterviewType(
        "Ingeniero de software",
        "Preguntas sobre codificación y sistemas",
        Icons.Default.Computer
    ),
    InterviewType(
        "Diseñador de productos",
        "Preguntas sobre UX, UI y diseño",
        Icons.Default.Brush
    )
)
