package com.unir.calculadorasalarionetocompose.Components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
fun EstadoCivil(onValueChange: (String) -> Unit){
    var selectedEstadoCivil by remember { mutableStateOf("Estado Civil") }
    val estadosCiviles = listOf("Casado", "Divorciado", "Separado", "Soltero", "Viudo")
    var isSelected by remember { mutableStateOf(false) }
    var expandedEstadoCivil by remember { mutableStateOf(false) }
    Column {
        Box(modifier = Modifier
            .padding(top = if (selectedEstadoCivil != "Estado Civil") 8.dp else 2.dp)
            .width(155.dp)
            .height(if (selectedEstadoCivil != "Estado Civil") 52.dp else 62.dp) // 62.dp
            .border(BorderStroke(1.dp, MaterialTheme.colorScheme.outline), shape = MaterialTheme.shapes.small)
            .clickable {
                isSelected = !isSelected
                expandedEstadoCivil = true },
            contentAlignment = Alignment.CenterStart,
        )
        {
            Text(
                modifier = Modifier
                .padding(start = 10.dp),
                text = selectedEstadoCivil,

            )
        }
        if (isSelected) {
            AlertDialog(
                onDismissRequest = { isSelected = false },
                title = { Text(text = "Selecciona tu estado civil") },
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
                        estadosCiviles.forEach { estadoCivil ->
                            Text(
                                text = estadoCivil,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        selectedEstadoCivil =
                                            estadoCivil // Actualiza el estado civil seleccionado
                                        onValueChange(selectedEstadoCivil)
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