package com.example.myapplication.presenter.views.posts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.myapplication.databinding.ActivityListarPostsBinding
import com.example.myapplication.presenter.viewModels.PostsViewModel

class ListPosts : AppCompatActivity() {

    private lateinit var binding: ActivityListarPostsBinding

    private val postViewModel: PostsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListarPostsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        postViewModel.data.observe(this, Observer {
        })
    }
}