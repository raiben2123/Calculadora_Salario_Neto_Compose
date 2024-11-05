package com.unir.calculadorasalarionetocompose.Components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
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
fun Contrato(){
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
        DropdownMenu(
            expanded = expandedContrato,
            onDismissRequest = {expandedContrato = true}
        ) {
            contratos.forEach{ contrato -> DropdownMenuItem(
                onClick = {
                    selectedContrato = contrato
                    expandedContrato = false
                },
                text = { Text(text = contrato) }
            )
            }
        }
    }
}