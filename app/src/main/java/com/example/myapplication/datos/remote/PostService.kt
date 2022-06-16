package com.example.myapplication.datos.remote

import com.example.myapplication.domain.model.Post.api.Posts
import com.example.myapplication.domain.repository.PostApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class PostService @Inject constructor(
    private val api: PostApiClient
) {
    suspend fun getPosts(): List<Posts> {
        return withContext(Dispatchers.IO) {//Ejecutamos lo siguiente en un hilo nuevo con corrutina
            val response: Response<List<Posts>> = api.getPosts("/posts")
            response.body()!! //y luego lo retornamos
        }
    }
}