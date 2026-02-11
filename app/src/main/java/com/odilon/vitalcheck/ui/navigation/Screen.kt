package com.odilon.vitalcheck.ui.navigation

sealed class Screen(val route: String) {

    object Dashboard : Screen("dashboard")

    object Entrada : Screen("entrada")

    object Resumo : Screen("resumo/{sintoma}/{dataHora}") {
        fun createRoute(sintoma: String, dataHora: String) =
            "resumo/$sintoma/$dataHora"
    }

}
