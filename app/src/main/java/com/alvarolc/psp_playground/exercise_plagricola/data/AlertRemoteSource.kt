package com.alvarolc.psp_playground.exercise_plagricola.data

import com.alvarolc.psp_playground.exercise_plagricola.app.ApiClient
import com.alvarolc.psp_playground.exercise_plagricola.domain.AlertModel


class AlertRemoteSource(private val apiClient: ApiClient){
    fun getAlerts():List<AlertModel>{
        return apiClient.getAlerts().map { it.toAlertModel() }
    }

    fun getAlert(alert_id: String): AlertModel? =
        apiClient.getAlert(alert_id)?.toAlertModel()
}