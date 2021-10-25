package com.alvarolc.psp_playground.ut02.folder.data

import com.alvarolc.psp_playground.ut02.folder.ApiClient

class UserRepository(private val apiClient: ApiClient) {
    fun getUsers(): List<UserApiModel> = apiClient.getUsers()
    fun getUser(userId: Int): UserApiModel? = apiClient.getUser(userId)
}