package com.alvarolc.psp_playground.ut02.folder.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * EndPoints de los servicios que se van a usar.
 * Es requisito de Retrofit crear esta interfaz.
 */
interface ApiEndPoint {
    @GET("users")
    fun getUsers(): Call<List<UserApiModel>>

    //@GET("posts")
    //fun getPosts(): Call<List<PostApiModel>>

    @GET("users/{userId}")
    fun getUser(@Path("userId") userId: Int): Call<UserApiModel>
}