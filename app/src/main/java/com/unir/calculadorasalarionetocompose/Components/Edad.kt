package com.unir.calculadorasalarionetocompose.Components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Edad(onValueChange: (String) -> Unit){
    var edad by remember { mutableStateOf("") }
    OutlinedTextField(
        value = edad,
        onValueChange = {newText -> edad = newText
                        onValueChange(newText)},
        label = { Text("Edad", fontSize = 13.sp) },
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier
            .height(60.dp)
            .width(155.dp),
        trailingIcon = { if (edad.isNotEmpty()){
            Text("años")
        }
        }
    )
}