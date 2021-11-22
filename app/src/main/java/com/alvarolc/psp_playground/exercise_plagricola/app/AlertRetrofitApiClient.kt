package com.alvarolc.psp_playground.exercise_plagricola.app

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AlertRetrofitApiClient : ApiClient {

    private val urlEndPoint: String = "https://plagricola.sitehub.es/api/public/"
    private var apiEndPoint: AlertApiEndPoint

    init {
        apiEndPoint = buildApiService()
    }

    /**
     * Creación del cliente con el Endpoint.
     * Definido por la librería Retrofit. Siempre es así.
     */
    private fun buildApiService(): AlertApiEndPoint {
        return buildClient().create(AlertApiEndPoint::class.java)
    }

    /**
     * Creación y configuración del cliente Retrofit.
     * Siempre es así.
     */
    private fun buildClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlEndPoint)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /**
     * Enpoint para obtener un listado de usuarios
     * @return List<UserPaiModel> listado de usuarios
     */
    override fun getAlerts(): List<AlertApiModel> {
        val call = apiEndPoint.getAlerts()
        val response = call.execute()
        if (response.isSuccessful) {
            val alerts = response.body()?.data
            //Si tiene alertas los devuelvo, sino, devuelvo un listado vacío.
            return alerts ?: mutableListOf()
        } else return mutableListOf()
    }


    override fun getAlert(alert_id: String): AlertApiModel? {
        val call = apiEndPoint.getAlert(alert_id)
        val response = call.execute()
        return if (response.isSuccessful) {
            response.body()?.data
        } else {
            null
        }
    }
}