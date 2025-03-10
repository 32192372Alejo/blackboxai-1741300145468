package com.example.interviewsimulator.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen() {
    var darkMode by remember { mutableStateOf(false) }
    var notificationsEnabled by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Configuración") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle navigation */ }) {
                        Icon(Icons.Default.ArrowBack, "Back")
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
                SettingsSection(title = "General") {
                    SettingsItem(
                        icon = Icons.Default.Language,
                        title = "Idioma",
                        subtitle = "Español",
                        onClick = { /* Handle language settings */ }
                    )
                    SettingsItem(
                        icon = Icons.Default.DarkMode,
                        title = "Modo oscuro",
                        onClick = { darkMode = !darkMode },
                        trailing = {
                            Switch(
                                checked = darkMode,
                                onCheckedChange = { darkMode = it }
                            )
                        }
                    )
                }
            }

            item {
                SettingsSection(title = "Notificaciones") {
                    SettingsItem(
                        icon = Icons.Default.Notifications,
                        title = "Notificaciones",
                        onClick = { notificationsEnabled = !notificationsEnabled },
                        trailing = {
                            Switch(
                                checked = notificationsEnabled,
                                onCheckedChange = { notificationsEnabled = it }
                            )
                        }
                    )
                }
            }

            item {
                SettingsSection(title = "Seguridad") {
                    SettingsItem(
                        icon = Icons.Default.Security,
                        title = "Cambiar contraseña",
                        onClick = { /* Handle password change */ }
                    )
                    SettingsItem(
                        icon = Icons.Default.PrivacyTip,
                        title = "Privacidad",
                        onClick = { /* Handle privacy settings */ }
                    )
                }
            }

            item {
                SettingsSection(title = "Acerca de") {
                    SettingsItem(
                        icon = Icons.Default.Info,
                        title = "Versión",
                        subtitle = "1.0.0",
                        onClick = { /* Handle version info */ }
                    )
                    SettingsItem(
                        icon = Icons.Default.Help,
                        title = "Ayuda",
                        onClick = { /* Handle help */ }
                    )
                }
            }
        }
    }
}

@Composable
private fun SettingsSection(
    title: String,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        content()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SettingsItem(
    icon: ImageVector,
    title: String,
    subtitle: String? = null,
    onClick: () -> Unit,
    trailing: @Composable (() -> Unit)? = {
        Icon(
            Icons.Default.ChevronRight,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
) {
    ListItem(
        headlineContent = { Text(title) },
        supportingContent = subtitle?.let { { Text(it) } },
        leadingContent = {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        },
        trailingContent = trailing,
        modifier = Modifier.clickable(onClick = onClick)
    )
}
