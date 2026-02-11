package com.odilon.vitalcheck.data.datasource

import com.odilon.vitalcheck.domain.model.VitalSigns
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeSensorDataSource {

    fun getVitalSigns(): Flow<VitalSigns> = flow {
        var steps = 1000

        while (true) {
            emit(
                VitalSigns(
                    heartRate = (60..100).random(),
                    steps = steps
                )
            )
            steps += (5..20).random()
            delay(3000)
        }
    }
}
