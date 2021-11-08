package com.alvarolc.psp_playground.exercise_plagricola.app

import com.alvarolc.psp_playground.exercise_plagricola.domain.AlertModel

data class AlertApiModel(
    val alert_id: String,
    val title: String,
    val summary: String,
    val type: String,
    val date: String
){
    fun toAlertModel(): AlertModel {
        return AlertModel(alert_id, title, type.toInt(),
            summary, date, "", "", emptyList())
    }
}