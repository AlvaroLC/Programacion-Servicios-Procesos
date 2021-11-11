package com.alvarolc.psp_playground.exercise_plagricola.data

import com.alvarolc.psp_playground.exercise_plagricola.domain.AlertModel
import com.alvarolc.psp_playground.exercise_plagricola.domain.AlertRepository
import com.alvarolc.psp_playground.exercise_plagricola.data.AlertRemoteSource


class AlertDataRepository (private val alertRemoteSource: AlertRemoteSource): AlertRepository {

    override fun getAlerts(): List<AlertModel> {
        return alertRemoteSource.getAlerts()
    }

    override fun getAlert(alert_id: String): AlertModel? =
        alertRemoteSource.getAlert(alert_id)
}


