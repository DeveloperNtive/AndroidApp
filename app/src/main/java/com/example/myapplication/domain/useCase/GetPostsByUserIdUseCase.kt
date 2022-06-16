package com.example.myapplication.domain.useCase

import com.example.myapplication.datos.repository.post.PostRepository
import com.example.myapplication.domain.model.Post.api.Posts
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


class GetPostsByUserIdUseCase @Inject constructor(
    val repository: PostRepository
) {
    suspend operator fun invoke(): List<Posts> {
        val postByUserId = repository.getPostsByUserId()
        return postByUserId
    }
}