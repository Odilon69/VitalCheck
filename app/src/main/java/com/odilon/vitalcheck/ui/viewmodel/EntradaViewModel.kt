package com.odilon.vitalcheck.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.odilon.vitalcheck.data.PreferencesDataStore
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class EntradaViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val context = application.applicationContext

    val ultimoSintoma = PreferencesDataStore
        .lerSintoma(context)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = ""
        )

    fun salvarSintoma(sintoma: String) {
        viewModelScope.launch {
            PreferencesDataStore.salvarSintoma(
                context,
                sintoma
            )
        }
    }
}
