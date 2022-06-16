package com.example.myapplication.domain.repository

import com.example.myapplication.domain.model.Post.api.Posts
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface PostApiClient {
//    Obtenemos todos los posts
    @GET()
    suspend fun getPosts(@Url url:String): Response<List<Posts>>

}