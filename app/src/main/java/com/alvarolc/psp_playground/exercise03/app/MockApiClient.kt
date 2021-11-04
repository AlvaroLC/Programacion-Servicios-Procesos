package com.alvarolc.psp_playground.exercise03.app

class MockApiClient : ApiClient {

    override fun getAlerts(): List<AlertApiModel> =
        mutableListOf(
            AlertApiModel("1", "Titulo 1", "Resumen alerta 1", "1", "2021-01-10"),
            AlertApiModel("2", "Titulo 2", "Resumen alerta 2", "1", "2021-01-09"),
            AlertApiModel("3", "Titulo 3", "Resumen alerta 3", "2", "2021-01-08"),
            AlertApiModel("4", "Titulo 4", "Resumen alerta 4", "2", "2021-01-07"),
            AlertApiModel("5", "Titulo 5", "Resumen alerta 5", "1", "2021-01-06"),
        )
}