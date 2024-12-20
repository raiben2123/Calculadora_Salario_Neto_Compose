package com.unir.calculadorasalarionetocompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun SecondScreen(
    contrato: String?,
    discapacidad: String?,
    hijos: Int,
    numPagas: Int,
    salario: Double
) {
    val deduccionSSSal = calcularDeduccionSS(salario, contrato)
    val deduccion = calcularHijos(hijos) + calcularDiscapacidad(discapacidad)
    val irpf = calcularIRPF(salario, deduccionSSSal, deduccion)
    val rIRPF = salario.minus(deduccionSSSal).times(irpf.toDouble() / 100).minus(deduccion)
    val salNeto = salario.minus(deduccionSSSal).minus(rIRPF)
    val salNetoMensual = salNeto.div(numPagas)
    val salNetoMensualFormateado = "%.2f".format(salNetoMensual)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp) // Espaciado uniforme
    ) {
        Text(
            text = "Resultado del cálculo",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 24.dp) // Separación superior
        )

        ResultCard("Salario Bruto", "$salario")
        ResultCard("Pago de Seguridad Social", "$deduccionSSSal")
        ResultCard("Deducciones por IRPF", "$deduccion")
        ResultCard("Porcentaje de Retención IRPF", "$irpf%")
        ResultCard("Resultado IRPF", "$rIRPF")
        ResultCard("Salario Neto Anual", "$salNeto")
        ResultCard("Salario Neto Mensual", "$salNetoMensualFormateado")
    }
}

@Composable
fun ResultCard(label: String, value: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(16.dp), // Espaciado interno
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = value,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

fun calcularDeduccionSS(salario: Double?, contrato: String?): Double {
    if (salario == null) return 0.0
    return when (contrato) {
        "General" -> salario * 0.0635
        "Inferior a un año" -> salario * 0.064
        else -> 0.0
    }
}

fun calcularIRPF(salario: Double?, deduccionSSSal: Double, deduccion: Int): Int {
    if (salario == null) return 0
    val resultado = salario - deduccionSSSal - deduccion
    return when (resultado) {
        in 0.0..12449.9 -> 0
        in 12450.0..20199.0 -> 19
        in 20200.0..35199.0 -> 24
        in 35200.0..59999.0 -> 30
        in 60000.0..299999.0 -> 37
        in 300000.0..Double.MAX_VALUE -> 45
        else -> 0
    }
}

fun calcularHijos(hijos: Int?): Int {
    val deduccion: Int
    when (hijos){
        0 -> {deduccion = 0
            return deduccion}
        1 -> {deduccion = 2400
            return deduccion}
        2 -> {deduccion = 2700+2400
            return deduccion}
        3 -> {deduccion = 4000+2700+2400
            return deduccion}
        else -> {deduccion = 4500+4000+2700+2400
            return deduccion}
    }
}

fun calcularDiscapacidad(discapacidad: String?): Int{
    val deduccion: Int
    when(discapacidad){
        "Sin discapacidad" -> {deduccion = 0
            return deduccion}
        "Mayor o igual al 65%" -> {deduccion = 9000
            return deduccion}
        "Menor del 65% (sin asistencia)" -> {deduccion = 3000
            return deduccion}
        "Menor del 65% (con asistencia)" -> {deduccion = 9000
            return deduccion}
    }
    return 0
}
