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

    private val alertRepository = AlertDataRepository(AlertRemoteSource(AlertRetrofitApiClient()))
    private val TAG: String = AlertActivity::class.java.simpleName


    fun getAlertViewModelScope() {

        viewModelScope.launch(Dispatchers.IO) {
            //Visualizo el listado de alerts
            val alerts = alertRepository.getAlerts()
            alerts.forEach { alertApiModel ->
                Log.d(TAG, "$alertApiModel")
            }

            //Obtengo una alerta y la visualizo
            val alert = alertRepository.getAlert("1671086")
            alert?.run {
                Log.d(TAG, "$this")
            }
        }

    }
}