package com.unir.calculadorasalarionetocompose.screens

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.unir.calculadorasalarionetocompose.Components.Contrato
import com.unir.calculadorasalarionetocompose.Components.Discapacidad
import com.unir.calculadorasalarionetocompose.Components.Edad
import com.unir.calculadorasalarionetocompose.Components.EstadoCivil
import com.unir.calculadorasalarionetocompose.Components.GrupoProfesional
import com.unir.calculadorasalarionetocompose.Components.Hijos
import com.unir.calculadorasalarionetocompose.Components.NumPagas
import com.unir.calculadorasalarionetocompose.Components.Salario

@Composable
fun MainScreen(navController: NavHostController) {
    var salario by remember { mutableStateOf("") }
    var numPagas by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var contrato by remember { mutableStateOf("") }
    var discapacidad by remember { mutableStateOf("") }
    var estadoCivil by remember { mutableStateOf("") }
    var hijos by remember { mutableStateOf("") }
    var grupoProfesional by remember { mutableStateOf("") }

    val primaryColor = MaterialTheme.colorScheme.primary
    val secondaryColor = MaterialTheme.colorScheme.secondary

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Calculadora de Salario Neto",
            style = MaterialTheme.typography.headlineMedium,
            color = primaryColor
        )
        Spacer(modifier = Modifier.height(40.dp))

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Salario { newSalario -> salario = newSalario }
                    Spacer(modifier = Modifier.width(16.dp))
                    NumPagas { newNumPagas -> numPagas = newNumPagas }
                }
            }
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Edad { newEdad -> edad = newEdad }
                    Spacer(modifier = Modifier.width(16.dp))
                    Contrato { newContrato -> contrato = newContrato }
                }
            }
            item {
                GrupoProfesional { newGrupoProf -> grupoProfesional = newGrupoProf }
            }
            item {
                Discapacidad { newDiscapacidad -> discapacidad = newDiscapacidad }
            }
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    EstadoCivil { newEstadoCivil -> estadoCivil = newEstadoCivil }
                    Spacer(modifier = Modifier.width(16.dp))
                    Hijos { newHijos -> hijos = newHijos }
                }
            }
        }

        Spacer(modifier = Modifier.height(40.dp))
        Button(
            onClick = {
                navController.navigate(
                    "SecondScreen/" +
                            "${Uri.encode(contrato)}/" +
                            "${Uri.encode(discapacidad)}/" +
                            "${hijos.ifEmpty { "0" }}/" +
                            "${numPagas.ifEmpty { "12" }}/" +
                            "${salario.ifEmpty { "0.0" }}"
                )
            },
            colors = ButtonDefaults.buttonColors(containerColor = secondaryColor),
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(50.dp)
                .clip(RoundedCornerShape(12.dp))
        ) {
            Text(
                text = "Calcular",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }
    }
}
