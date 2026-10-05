package com.example.aula7atdcasa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme{
                TelaEvento()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EventsTelaPreview() {
    MaterialTheme {
        TelaEvento()
    }
}

/*
    Esse OptIn é pq o TopAppBar dá um erro avisando que ele vai ser removido futuramente, aí pede pra colocar
    essa tag aí
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaEvento () {
    // Estado com remember e mutablestate
    var nome by remember { mutableStateOf("") }
    // Estrutura principal (scaffold)
    Scaffold(
        topBar = {
            // TopAppBar com o nome de "Eventos UFC"
            TopAppBar(
                title = {Text("Eventos UFC")},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                // innerPadding do scaffold
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Dados do evento em um card
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    // Cores do materialtheme.colorScheme
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text (
                        text = "Workshop: Meu primeiro site",
                        // Tipografia 1
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold

                    )

                    Text (
                        text = "Primeiros passos para a criação de sites com HTML e CSS",
                        // Tipografia 2
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(4.dp))

                    Text (
                        text = ("15 de outubro * 14:00\nCampus de Russas -- Laboratório 01"),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            Text (
                text = "Inscrição",
                style = MaterialTheme.typography.titleMedium
            )

            Text (
                text = "Digite seu nome para demonstrar interesse:"
            )
            // Textfield
            TextField(
                value = nome,
                onValueChange = { nome = it},
                label = {Text("Nome do participante")},
                // Modifier de largura
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            // Botão do "quero participar"
            Button(
                onClick = {},
                // Não aparece enquanto o nome for vazio
                enabled = nome.isNotBlank(),
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.small
            ) {
                Text("QUERO PARTICIPAR")
            }
        }

    }
}