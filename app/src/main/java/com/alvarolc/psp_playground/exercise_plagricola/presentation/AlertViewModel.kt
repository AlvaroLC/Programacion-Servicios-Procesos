package com.alvarolc.psp_playground.exercise_plagricola.presentation

import androidx.lifecycle.ViewModel
import com.alvarolc.psp_playground.exercise_plagricola.domain.GetAlertsUseCase

class AlertViewModel(private val getAlertsUseCase: GetAlertsUseCase) : ViewModel() {
    fun getAllAlerts() = getAlertsUseCase.execute()
}