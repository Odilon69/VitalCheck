package com.odilon.vitalcheck.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.odilon.vitalcheck.ui.navigation.Screen
import com.odilon.vitalcheck.ui.screens.DashboardScreen
import com.odilon.vitalcheck.ui.screens.EntradaScreen
import com.odilon.vitalcheck.ui.screens.ResumoScreen
import android.net.Uri
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun VitalCheckApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Dashboard.route
    ) {

        composable(Screen.Dashboard.route) {
            DashboardScreen(
                onNovaEntrada = {
                    navController.navigate(Screen.Entrada.route)
                }
            )
        }

        composable(Screen.Entrada.route) {
            EntradaScreen(
                onSalvar = { sintoma ->

                    // Data e hora atuais (compatível com API 24)
                    val formatter = SimpleDateFormat(
                        "dd/MM/yyyy HH:mm",
                        Locale.getDefault()
                    )
                    val dataHora = formatter.format(Date())

                    val sintomaEncoded = Uri.encode(sintoma)
                    val dataHoraEncoded = Uri.encode(dataHora)

                    navController.navigate(
                        Screen.Resumo.createRoute(
                            sintomaEncoded,
                            dataHoraEncoded
                        )
                    )
                }
            )
        }

        composable(
            route = Screen.Resumo.route
        ) { backStackEntry ->

            val sintoma = Uri.decode(
                backStackEntry.arguments?.getString("sintoma") ?: ""
            )

            val dataHora = Uri.decode(
                backStackEntry.arguments?.getString("dataHora") ?: ""
            )

            ResumoScreen(
                sintoma = sintoma,
                dataHora = dataHora
            )
        }

    }

}
