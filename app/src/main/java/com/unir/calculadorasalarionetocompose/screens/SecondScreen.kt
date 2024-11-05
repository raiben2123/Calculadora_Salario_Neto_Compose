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
    salario: String?,
    restaSal: Double? = calcularNeto(salario),
    deduccion: Int = calcularHijos(hijos) + calcularDiscapacidad(discapacidad),
    salNeto: Double? = calcularSalNeto(salario, deduccion, restaSal),
    irpfFinal: String = calcularIRPF(salario, salNeto).toString()
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Salario bruto: $salario")
        Text("Salario neto: $salNeto")
        if (salNeto != null) {
            if (numPagas != null) {
                Text("Salario mensual: " + salNeto/numPagas.toInt())
            }
        }
        Text("Retención de IRPF: $irpfFinal"+"%")
        Text("Posibles deducciones: $deduccion")
    }
}

fun calcularNeto(salario: String?): Double? {
    val salarioInt = salario?.toDouble()
    if (salarioInt != null){
        if (salarioInt <= 12450){
            val IRPF = 0.19
            val restaSal = salarioInt * IRPF
            return restaSal
        }else{
            if (salarioInt <= 20199){
                val IRPF = 0.24
                val restaSal = salarioInt * IRPF
                return restaSal
            }else{
                if (salarioInt <= 35199){
                    val IRPF = 0.30
                    val restaSal = salarioInt * IRPF
                    return restaSal
                }else{
                    if (salarioInt <= 59999){
                        val IRPF = 0.37
                        val restaSal = salarioInt * IRPF
                        return restaSal
                    }else{
                        if (salarioInt <= 299999){
                            val IRPF = 0.45
                            val restaSal = salarioInt * IRPF
                            return restaSal
                        }else{
                            if (salarioInt >= 300000){
                                val IRPF = 0.47
                                val restaSal = salarioInt * IRPF
                                return restaSal
                            }
                        }
                    }
                }
            }
        }
    }else{
        return null
    }
    return null
}
fun calcularHijos(hijos: String?): Int {
    val hijosInt = hijos?.toInt()
    val deduccion: Int
    when (hijosInt){
        0 -> {deduccion = 0
            return deduccion}
        1 -> {deduccion = 2400
            return deduccion}
        2 -> {deduccion = 2700
            return deduccion}
        3 -> {deduccion = 4000
            return deduccion}
        else -> {deduccion = 4500
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
fun calcularSalNeto(salario: String?, deduccion: Int, restaSal: Double?): Double? {
    val salInt = salario?.toInt()
    var totalResta = 0.0
    if (deduccion > restaSal!!){
        if (salInt != null) {
            totalResta = salInt - (restaSal - restaSal)
        }
        return totalResta
    } else{
        if (salInt != null) {
            totalResta = salInt - (restaSal - deduccion)
            return totalResta
        }
    }
    return null
}
fun calcularIRPF(salario: String?,salNeto: Double?): Double? {
    val salarioInt = salario?.toInt()
    val irpfAplicado = salarioInt?.minus(salNeto!!)
    val irpfPorcentaje = irpfAplicado?.div(salarioInt)?.times(100)
    return irpfPorcentaje
}
