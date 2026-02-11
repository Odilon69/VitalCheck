package com.odilon.vitalcheck.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Nome do arquivo
private const val DATASTORE_NAME = "vitalcheck_prefs"

// Extension do Context
val Context.dataStore by preferencesDataStore(
    name = DATASTORE_NAME
)

object PreferencesDataStore {

    private val LAST_SINTOMA = stringPreferencesKey("last_sintoma")

    suspend fun salvarSintoma(
        context: Context,
        sintoma: String
    ) {
        context.dataStore.edit { prefs ->
            prefs[LAST_SINTOMA] = sintoma
        }
    }

    fun lerSintoma(
        context: Context
    ): Flow<String> {
        return context.dataStore.data.map { prefs ->
            prefs[LAST_SINTOMA] ?: ""
        }
    }
}
