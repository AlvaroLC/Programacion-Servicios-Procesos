package com.alvarolc.psp_playground.exercise_plagricola.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvarolc.psp_playground.exercise_plagricola.app.AlertRetrofitApiClient
import com.alvarolc.psp_playground.exercise_plagricola.data.AlertDataRepository
import com.alvarolc.psp_playground.exercise_plagricola.data.AlertRemoteSource
import com.alvarolc.psp_playground.exercise_plagricola.domain.GetAlertsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AlertViewModel : ViewModel() {

    private val userRepository = AlertDataRepository(AlertRemoteSource(AlertRetrofitApiClient()))
    private val TAG: String = AlertActivity::class.java.simpleName


    fun getUserViewModelScope() {

        viewModelScope.launch(Dispatchers.IO) {
            //Visualizo el listado de alerts
            val alerts = userRepository.getAlerts()
            alerts.forEach { userApiModel ->
                Log.d(TAG, "$userApiModel")
            }

            //Obtengo un usuario y visualizo el usuario
            val alert = userRepository.getAlert("1671086")
            alert?.run {
                Log.d(TAG, "$this")
            }
        }

    }
}