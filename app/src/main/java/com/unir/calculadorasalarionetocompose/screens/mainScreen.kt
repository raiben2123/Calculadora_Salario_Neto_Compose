package com.unir.calculadorasalarionetocompose.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.unir.calculadorasalarionetocompose.Components.Contrato
import com.unir.calculadorasalarionetocompose.Components.Discapacidad
import com.unir.calculadorasalarionetocompose.Components.Edad
import com.unir.calculadorasalarionetocompose.Components.EstadoCivil
import com.unir.calculadorasalarionetocompose.Components.GrupoProfesional
import com.unir.calculadorasalarionetocompose.Components.Hijos
import com.unir.calculadorasalarionetocompose.Components.NumPagas
import com.unir.calculadorasalarionetocompose.Components.Salario


@Preview
@Composable
fun mainScreen() {
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
                Salario()
                Spacer(modifier = Modifier.width(17.dp))
                NumPagas()
            }
        Spacer(modifier = Modifier.height(10.dp))
            Row (modifier = Modifier
                .fillMaxWidth(),
            ){
                Edad()
                Spacer(modifier = Modifier.width(17.dp))
                Contrato()
            }
        Spacer(modifier = Modifier.height(10.dp))
            GrupoProfesional()
        Spacer(modifier = Modifier.height(10.dp))
            Discapacidad()
        Spacer(modifier = Modifier.height(10.dp))
            Row (modifier = Modifier
                .fillMaxWidth(),
            ){
                EstadoCivil()
                Spacer(modifier = Modifier.width(17.dp))
                Hijos()
            }
        Spacer(modifier = Modifier.height(40.dp))

    }
}