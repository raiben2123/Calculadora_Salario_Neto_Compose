package com.unir.calculadorasalarionetocompose.screens

import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        ){
        Spacer(modifier = Modifier.height(45.dp))
            Box (modifier = Modifier
                .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Text("Calculadora de salario neto", fontSize = 15.sp )
            }
        Spacer(modifier = Modifier.height(60.dp))
            Row (modifier = Modifier
                .fillMaxWidth(),
            ){
                Salario { newSalario -> salario = newSalario }
                Spacer(modifier = Modifier.width(17.dp))
                NumPagas { newNumPagas -> numPagas = newNumPagas }
            }
        Spacer(modifier = Modifier.height(10.dp))
            Row (modifier = Modifier
                .fillMaxWidth(),
            ){
                Edad { newEdad -> edad = newEdad }
                Spacer(modifier = Modifier.width(17.dp))
                Contrato { newContrato -> contrato = newContrato }
            }
        Spacer(modifier = Modifier.height(10.dp))
            GrupoProfesional { newGrupoProf -> grupoProfesional = newGrupoProf }
        Spacer(modifier = Modifier.height(10.dp))
            Discapacidad { newDiscapacidad -> discapacidad = newDiscapacidad }
        Spacer(modifier = Modifier.height(10.dp))
            Row (modifier = Modifier
                .fillMaxWidth(),
            ){
                EstadoCivil { newEstadoCivil -> estadoCivil = newEstadoCivil }
                Spacer(modifier = Modifier.width(17.dp))
                Hijos { newHijos -> hijos = newHijos }
            }
        Spacer(modifier = Modifier.height(40.dp))
        Button(onClick = {navController.navigate( "SecondScreen/" +
                "${Uri.encode(contrato)}/" +
                "${Uri.encode(discapacidad)}/" +
                "${hijos.ifEmpty { "0" }}/" +
                "${numPagas.ifEmpty { "12" }}/" +
                "${salario.ifEmpty { "0.0" }}"
        )}) {
            Text("Calcular")
        }
    }
}