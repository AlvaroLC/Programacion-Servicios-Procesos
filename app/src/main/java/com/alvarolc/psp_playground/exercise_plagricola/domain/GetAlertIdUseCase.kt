package com.alvarolc.psp_playground.exercise_plagricola.domain

class GetAlertIdUseCase(private val alertRepository: AlertRepository) {
    fun execute(alertId: String): AlertModel? = alertRepository.getAlert(alertId)
}
