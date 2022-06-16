package com.example.myapplication.presenter.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.domain.model.Post.api.Posts
import com.example.myapplication.presenter.viewHolders.PostViewHolder

class PostAdapter(private val postsList: List<Posts>) : RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        //Devolverle al ViewHolder el layout que va a modificar
        val layoutInflater = LayoutInflater.from(parent.context)
        return PostViewHolder(layoutInflater.inflate(R.layout.each_posts_user_item, parent, false))
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val item = postsList[position] //Necesitamos un List<UsersEntity>
        holder.render(item)
    }

    override fun getItemCount(): Int = postsList.size

}
