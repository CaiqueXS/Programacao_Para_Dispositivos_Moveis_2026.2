package com.example.aula6atdcasa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tela()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TelaPreview() {
    Tela()
}

@Composable
fun Tela() {
    // Aqui fica o modifier, com toda a tela se estruturando aqui nesse column
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Seb's")
        Spacer(modifier = Modifier.height(5.dp))
        Text("Comida & Jazz")
        Spacer(modifier = Modifier.height(5.dp))

        // Aqui é usado um row para a avalição e tempo ficarem lado a lado
        Row {
            Text("Avaliação: 4.8")
            Spacer(modifier = Modifier.width(24.dp))
            Text("Tempo: 30-40min")
        }
        // Variáveis usadas para os estados
        var qtd by remember { mutableIntStateOf(1) }
        val preco by remember { mutableFloatStateOf(54.30f) }
        val novopreco = qtd * preco

        Spacer(modifier = Modifier.height(5.dp))
        Text("Prato da noite: Camarão Empanado")
        Spacer(modifier = Modifier.height(10.dp))
        Text("R$: %.2f".format(novopreco))
        Spacer(modifier = Modifier.height(20.dp))

        // Aqui é onde os estados são alterados, dentro de um row
        Row {
            Button(onClick = {qtd++}) {
                Text("[ + ]")
            }

            Text("Quantidade: $qtd")

            Button(onClick = {
                if (qtd > 1) qtd--
            }) {
                Text("[ - ]")
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {}) {
            Text("FAZER PEDIDO")
        }
    }
}