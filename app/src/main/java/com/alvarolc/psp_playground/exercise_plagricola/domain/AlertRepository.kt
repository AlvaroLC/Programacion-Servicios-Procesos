package com.alvarolc.psp_playground.exercise_plagricola.domain


interface AlertRepository {
    fun getAlerts(): List<AlertModel>
    fun getAlert(alert_id: String): AlertModel?
}