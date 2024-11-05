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
fun Contrato(onValueChange: (String) -> Unit){
    var selectedContrato by remember { mutableStateOf("Contrato") }
    val contratos = listOf("General", "Inferior a un año")
    var isSelected by remember { mutableStateOf(false) }
    var expandedContrato by remember { mutableStateOf(false) }
    Column {
        Box(modifier = Modifier
            .padding(top = if (selectedContrato != "Contrato") 8.dp else 2.dp) //
            .width(155.dp)
            .height(if (selectedContrato != "Contrato") 52.dp else 62.dp) // 62.dp
            .border(BorderStroke(1.dp, MaterialTheme.colorScheme.outline), shape = MaterialTheme.shapes.extraSmall)
            .clickable {
                isSelected = !isSelected
                expandedContrato = true },
            contentAlignment = Alignment.CenterStart,
        )
        {
            Text(
                modifier = Modifier
                .padding(start = 10.dp),
                text = selectedContrato,
            )
        }
        if (isSelected) {
            AlertDialog(
                onDismissRequest = { isSelected = false },
                title = { Text(text = "Selecciona tu tipo de contrato") },
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
                        contratos.forEach { contrato ->
                            Text(
                                text = contrato,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        selectedContrato =
                                            contrato // Actualiza el estado civil seleccionado
                                        onValueChange(selectedContrato)
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