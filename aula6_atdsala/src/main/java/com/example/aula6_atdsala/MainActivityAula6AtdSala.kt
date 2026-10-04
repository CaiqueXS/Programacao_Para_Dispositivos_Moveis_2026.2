package com.example.aula6_atdsala

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.ui.tooling.preview.Preview

class MainActivityAula6AtdSala: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            CartaoAluno()
        }
    }
}
@Preview(showBackground = true)
@Composable
fun CartaoAluno() {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "MEU PRIMEIRO APP")
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "Maria Santos")
        Text(text = "Engenharia da Computação")
        Text(text = "Russas • Ceará")
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            var curtidas by remember { mutableIntStateOf(0)}
            Button(onClick = {curtidas ++}) {Text(text = "CURTIR ($curtidas)")}
            Button(onClick = {}) {Text("CONTATO")}
        }
    }

}


@Composable
fun Contador () {
    var contador by remember { mutableIntStateOf(0) }

    Button(onClick = {contador++}) {
        Text(text = "Cliques: $contador")
    }
}

@Composable
fun TesteModifierPreview() {
    TesteModifier()
}

@Composable
fun TesteModifier() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("PERFIL DO ALUNO")
        Spacer(modifier = Modifier.height(24.dp))

        Text("Jonas Mamão")
        Text("Ciência da Computaria")
        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {}) {
            Text(text= "VER PERFIL")
        }
    }
}

@Composable
fun TesteBox() {
    Box() {
        Text("Box content")
    }
}
@Composable
fun TesteRow() {
    Row() {
        Button (onClick = {}) { Text("Sim")}
        Button (onClick = {}) { Text("Não")}
    }
}
@Composable
fun TesteColum () {
    Column() {
        Text("Primeiro")
        Text("Segundo")
        Text("Terceiro")
    }
}
@Composable
fun Botao() {
    Button(
        onClick = {
        }
    ) {
        Text(text = "Botão")
    }
}
@Composable
fun Saudacao() {
    Text(text = "Olá, mundo")
}