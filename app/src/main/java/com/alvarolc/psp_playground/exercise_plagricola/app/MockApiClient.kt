package com.alvarolc.psp_playground.exercise_plagricola.app


import com.alvarolc.psp_playground.exercise_plagricola.domain.AlertModel
import com.alvarolc.psp_playground.exercise_plagricola.domain.FileModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
/**
class MockApiClient : ApiClient {

    override fun getAlerts(): List<AlertModel> =
        mutableListOf(
            AlertModel("1", "Titulo 1", 1, "Resumen alerta 1", "2021-01-10", "Cuerpo1", "", mutableListOf(
                FileModel("name 01", "url 01")
            )),
            AlertModel("2", "Titulo 2", 2, "Resumen alerta 2", "2021-01-11", "Cuerpo2", "", mutableListOf(FileModel("name 02", "url 02"))),
            AlertModel("3", "Titulo 3", 3, "Resumen alerta 3", "2021-01-12", "Cuerpo3", "", mutableListOf(FileModel("name 03", "url 03"))),
            AlertModel("4", "Titulo 4", 4, "Resumen alerta 4", "2021-01-13", "Cuerpo4", "", mutableListOf(FileModel("name 04", "url 04"))),
            AlertModel("5", "Titulo 5", 5, "Resumen alerta 5", "2021-01-14", "Cuerpo5", "", mutableListOf(FileModel("name 05", "url 05"))),
            AlertModel("6", "Titulo 6", 6, "Resumen alerta 6", "2021-01-15", "Cuerpo6", "", mutableListOf(FileModel("name 06", "url 06"))),
        )
}*/

class RetrofitApiClient : ApiClient {

    private val urlEndPoint: String = "https://plagricola.sitehub.es/api/public/alerts/"
    private var apiEndPoint: ApiEndPoint

    init {
        apiEndPoint = buildApiService()
    }

    /**
     * Creación del cliente con el Endpoint.
     * Definido por la librería Retrofit. Siempre es así.
     */
    private fun buildApiService(): ApiEndPoint {
        return buildClient().create(ApiEndPoint::class.java)
    }

    private fun buildClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlEndPoint)
            .client(buildHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun buildHttpClient() =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().also{
                it.level = HttpLoggingInterceptor.Level.BODY
            })
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()


    override fun getAlerts(): List<AlertApiModel> {
        val call = apiEndPoint.getAlerts()
        val response = call.execute()
        if (response.isSuccessful) {
            val alerts = response.body()?.data
            //Si tiene alertas los devuelvo, sino, devuelvo un listado vacío.
            return alerts ?: mutableListOf()
        } else return mutableListOf()
    }

}