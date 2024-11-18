package com.unir.calculadorasalarionetocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.unir.calculadorasalarionetocompose.screens.MainScreen
import com.unir.calculadorasalarionetocompose.screens.SecondScreen
import com.unir.calculadorasalarionetocompose.ui.theme.CalculadoraSalarioNetoComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraSalarioNetoComposeTheme {
                val navController = rememberNavController()
                MyApp(navController)
            }
        }
    }
}

@Composable
fun MyApp(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "MainScreen") {
        composable("MainScreen") { MainScreen(navController) }
        composable(
            "SecondScreen/{contrato}/{discapacidad}/{hijos}/{numPagas}/{salario}",
            arguments = listOf(
                navArgument("contrato") { defaultValue = "Sin especificar" },
                navArgument("discapacidad") { defaultValue = "Sin especificar" },
                navArgument("hijos") { defaultValue = "0" },
                navArgument("numPagas") { defaultValue = "12" },
                navArgument("salario") { defaultValue = "0.0" }
            )
        ) { backStackEntry ->
            val contrato = backStackEntry.arguments?.getString("contrato")
            val discapacidad = backStackEntry.arguments?.getString("discapacidad")
            val hijos = backStackEntry.arguments?.getString("hijos")?.toIntOrNull() ?: 0
            val numPagas = backStackEntry.arguments?.getString("numPagas")?.toIntOrNull() ?: 12
            val salario = backStackEntry.arguments?.getString("salario")?.toDoubleOrNull() ?: 0.0

            SecondScreen(
                contrato = contrato,
                discapacidad = discapacidad,
                hijos = hijos,
                numPagas = numPagas,
                salario = salario
            )
        }
    }
}