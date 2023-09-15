package com.example.testtsk.network

import com.example.testtsk.model.JokeModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TestTaskService {

    @GET("/jokes/categories/")
    suspend fun getJokeList(): Response<List<String>>

    //@GET("/jokes/random?category={category}")
    @GET("/jokes/random")
    suspend fun getJoke(
        @Query("category") category: String
    ): Response<JokeModel>
}