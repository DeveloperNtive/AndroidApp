package com.example.myapplication.datos.repository.post

import com.example.myapplication.datos.remote.PostService
import com.example.myapplication.domain.model.Post.api.Posts
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val api: PostService,
) {
    //    Obtener usuarios desde API
    suspend fun getPostsByUserId(): List<Posts> {//Se manejara el mismo modelo de datos
        return api.getPosts()
    }
}