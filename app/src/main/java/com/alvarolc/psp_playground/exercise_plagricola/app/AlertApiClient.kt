package com.alvarolc.psp_playground.exercise_plagricola.app

/**
 * Abstracción del cliente que vamos a usar en la actividad.
 */
interface ApiClient {
    fun getAlerts(): List<AlertApiModel>
    fun getAlert(alert_id:String):AlertApiModel?
}