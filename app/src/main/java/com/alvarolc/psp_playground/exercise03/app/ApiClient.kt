package com.alvarolc.psp_playground.exercise03.app

interface ApiClient {
    fun getAlerts(): List<AlertApiModel>
}