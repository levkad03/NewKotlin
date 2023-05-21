package com.example.lab9

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitAPI {
    @GET("/posts")
    fun getAllPosts(): Call<List<Posts>>

    @POST("/posts")
    fun createNewPost(@Body post: Posts):Call<Posts>
}