package com.alvarolc.psp_playground.exercise_plagricola.domain

class GetAlertsUseCase(private val alertRepository: AlertRepository) {
    fun execute(): List<AlertModel> = alertRepository.getAlerts()
}
