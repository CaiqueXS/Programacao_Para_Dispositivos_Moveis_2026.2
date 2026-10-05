package com.example.aula7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PerfilTela()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PerfilTelaPreview() {
    PerfilTela()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerfilTela() {
    var nome by remember { mutableStateOf("")}
    var curso by remember { mutableStateOf("")}
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Meu perfil") })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Dados pessoais",
                style = MaterialTheme.typography.titleLarge
            )

            TextField(
                value = nome,
                onValueChange = { nome = it},
                label = {Text("Nome")}
            )

            TextField(
                value = curso,
                onValueChange = { curso = it},
                label = {Text("Curso")}
            )

            Button(onClick = {}) {
                Text("SALVAR")
            }
        }
    }
}