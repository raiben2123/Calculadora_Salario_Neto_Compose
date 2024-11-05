package com.unir.calculadorasalarionetocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.unir.calculadorasalarionetocompose.screens.MainScreen
import com.unir.calculadorasalarionetocompose.screens.SecondScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MyApp(navController)
        }
    }
}

@Composable
fun MyApp(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "MainScreen") {
        composable("MainScreen") { MainScreen(navController) }
        composable("SecondScreen/{contrato}/{discapacidad}/{edad}/{estadoCivil}/{grupoProfesional}/{hijos}/{numPagas}/{salario}") { backStackEntry ->
            val contrato = backStackEntry.arguments?.getString("contrato")
            val discapacidad = backStackEntry.arguments?.getString("discapacidad")
            val edad = backStackEntry.arguments?.getString("edad")
            val estadoCivil = backStackEntry.arguments?.getString("estadoCivil")
            val grupoProfesional = backStackEntry.arguments?.getString("grupoProfesional")
            val hijos = backStackEntry.arguments?.getString("hijos")
            val numPagas = backStackEntry.arguments?.getString("numPagas")
            val salario = backStackEntry.arguments?.getString("salario")

            SecondScreen(
                contrato,
                discapacidad,
                edad,
                estadoCivil,
                grupoProfesional,
                hijos,
                numPagas,
                salario
            )
        }
    }
}