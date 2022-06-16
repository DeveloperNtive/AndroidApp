package com.example.myapplication.presenter.viewHolders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.domain.model.Post.api.Posts

class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val titulo = view.findViewById<TextView>(R.id.tvPostsTitulo)
    val body = view.findViewById<TextView>(R.id.tvBodyApi)

    fun render(post: Posts) {
        titulo.text = post.title
        body.text = post.body
    }
}