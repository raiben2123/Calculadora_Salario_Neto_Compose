package com.unir.calculadorasalarionetocompose.Components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



@Composable
fun Discapacidad(onValueChange: (String) -> Unit){
    var selectedDiscapacidad by remember { mutableStateOf("Grado de Discapacidad") }
    val discapacidades = listOf("Sin discapacidad","Mayor o igual al 65%", "Menor del 65% (sin asistencia)", "Menor del 65% (con asistencia)")
    var isSelected by remember { mutableStateOf(false) }
    var expandedDiscapacidad by remember { mutableStateOf(false) }
    Column {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .border(BorderStroke(1.dp, MaterialTheme.colorScheme.outline), shape = MaterialTheme.shapes.small)
            .clickable {
                isSelected = !isSelected
                expandedDiscapacidad = true },
            contentAlignment = Alignment.CenterStart,
        )
        {
            Text(
                modifier = Modifier
                .padding(start = 10.dp),
                text = selectedDiscapacidad,
            )
        }
        if (isSelected) {
            AlertDialog(
                onDismissRequest = { isSelected = false },
                title = { Text(text = "Selecciona tu % de discapacidad") },
                confirmButton = {
                    Button(onClick = { isSelected = false }) {
                        Text("Confirmar")
                    }
                },
                dismissButton = {
                    Button(onClick = { isSelected = false }) {
                        Text("Cancelar")
                    }
                },
                text = {
                    Column {
                        discapacidades.forEach { discapacidad ->
                            Text(
                                text = discapacidad,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        selectedDiscapacidad =
                                            discapacidad // Actualiza el estado civil seleccionado
                                        onValueChange(selectedDiscapacidad)
                                        isSelected = false // Cierra el diálogo
                                    }
                                    .padding(16.dp)
                            )
                        }
                    }
                }
            )
        }
    }
}