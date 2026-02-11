//package com.odilon.vitalcheck.ui.screens
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.compose.material3.Button
//import androidx.compose.material3.TextField
//import androidx.compose.runtime.*
//import androidx.compose.foundation.layout.fillMaxSize
//import com.odilon.vitalcheck.ui.viewmodel.EntradaViewModel
//
//@Composable
//fun EntradaScreen(
//    onSalvar: (String) -> Unit,
//    viewModel: EntradaViewModel = viewModel()
//) {
//    var sintoma by remember { mutableStateOf("") }
//    val ultimoSintoma by viewModel.ultimoSintoma.collectAsState()
//
//    Column(modifier = Modifier.padding(16.dp)) {
//
//        Text("Último sintoma salvo:")
//        Text(
//            text = ultimoSintoma.ifBlank { "Nenhum" }
//        )
//
//        Text(text = "Digite o sintoma")
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        TextField(
//            value = sintoma,
//            onValueChange = { sintoma = it },
//            label = { Text("Sintoma") }
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Button(
//            onClick = {
//                viewModel.salvarSintoma(sintoma)
//                onSalvar(sintoma)
//            }
//        ) {
//            Text("Salvar")
//        }
//    }
//}
package com.odilon.vitalcheck.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MedicalServices
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.odilon.vitalcheck.ui.viewmodel.EntradaViewModel
import androidx.compose.material3.ExperimentalMaterial3Api

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntradaScreen(
    onSalvar: (String) -> Unit,
    viewModel: EntradaViewModel = viewModel()
) {

    var sintoma by remember { mutableStateOf("") }
    val ultimoSintoma by viewModel.ultimoSintoma.collectAsState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Registrar Sintoma") }
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            // Card Último Sintoma
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.MedicalServices,
                        contentDescription = null
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    Column {
                        Text("Último sintoma salvo")
                        Text(
                            text = ultimoSintoma.ifBlank { "Nenhum" },
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }

            Text(
                text = "Descreva o sintoma",
                style = MaterialTheme.typography.titleMedium
            )

            OutlinedTextField(
                value = sintoma,
                onValueChange = { sintoma = it },
                label = { Text("Sintoma") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = false,
                minLines = 3
            )

            Button(
                onClick = {
                    if (sintoma.isNotBlank()) {
                        viewModel.salvarSintoma(sintoma)
                        onSalvar(sintoma)
                        sintoma = ""
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.Save,
                    contentDescription = null
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text("Salvar Sintoma")
            }
        }
    }
}
