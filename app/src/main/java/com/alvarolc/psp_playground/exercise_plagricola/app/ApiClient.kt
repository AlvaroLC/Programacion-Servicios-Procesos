package com.alvarolc.psp_playground.exercise_plagricola.app

import com.alvarolc.psp_playground.exercise_plagricola.domain.AlertModel

interface ApiClient {
    fun getAlerts(): List<AlertApiModel>
}