package com.alvarolc.psp_playground.ut02.folder

import com.alvarolc.psp_playground.ut02.folder.data.ApiEndPoint
import com.alvarolc.psp_playground.ut02.folder.data.UserApiModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface ApiClient {
    fun getUsers(): List<UserApiModel>
    fun getUser(userId: Int): UserApiModel?
}

class MockApiClient : ApiClient {
    override fun getUsers(): List<UserApiModel> {
        return mutableListOf(
            UserApiModel(1, "Usuario 1", "Usuario1", "user@email.es"),
            UserApiModel(2, "Usuario 2", "Usuario2", "user@email.es"),
            UserApiModel(3, "Usuario 3", "Usuario3", "user@email.es"),
            UserApiModel(4, "Usuario 4", "Usuario4", "user@email.es"),
        )
    }

    override fun getUser(userId: Int): UserApiModel {
        return UserApiModel(1, "Usuario 1", "Usuario1", "user1@email.es")
    }
}

class RetrofitApiClient : ApiClient {

    private val urlEndPoint: String = "https://jsonplaceholder.typicode.com/"
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
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    override fun getUsers(): List<UserApiModel> {
        val call = apiEndPoint.getUsers()
        val response = call.execute()
        if (response.isSuccessful) {
            val users = response.body()
            //Si tiene usuarios los devuelvo, sino, devuelvo un listado vacío.
            return users ?: mutableListOf()
        } else {
            return mutableListOf()
        }
    }

    override fun getUser(userId: Int): UserApiModel? {
        val call = apiEndPoint.getUser(userId)
        val response = call.execute()
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }
}

