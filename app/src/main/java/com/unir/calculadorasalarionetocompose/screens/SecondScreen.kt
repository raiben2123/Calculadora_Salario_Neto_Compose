package com.unir.calculadorasalarionetocompose.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun SecondScreen(
    contrato: String?,
    discapacidad: String?,
    edad: String?,
    estadoCivil: String?,
    grupoProfesional: String?,
    hijos: String?,
    numPagas: String?,
    salario: String?
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Contrato: $contrato")
        Text("Discapacidad: $discapacidad")
        Text("Edad: $edad")
        Text("Estado Civil: $estadoCivil")
        Text("Grupo Profesional: $grupoProfesional")
        Text("Hijos: $hijos")
        Text("Número de Pagas: $numPagas")
        Text("Salario: $salario")
    }
}