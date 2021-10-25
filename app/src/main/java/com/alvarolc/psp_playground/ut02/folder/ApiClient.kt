package com.alvarolc.psp_playground.ut02.folder

import com.alvarolc.psp_playground.ut02.folder.data.UserApiModel

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

