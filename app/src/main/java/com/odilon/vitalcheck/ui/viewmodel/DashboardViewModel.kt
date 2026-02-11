package com.odilon.vitalcheck.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.odilon.vitalcheck.data.datasource.FakeSensorDataSource
import com.odilon.vitalcheck.domain.model.VitalSigns
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class DashboardViewModel : ViewModel() {

    private val sensorDataSource = FakeSensorDataSource()

    val vitalSigns = sensorDataSource.getVitalSigns()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Companion.WhileSubscribed(5000),
            initialValue = VitalSigns(0, 0)
        )
}