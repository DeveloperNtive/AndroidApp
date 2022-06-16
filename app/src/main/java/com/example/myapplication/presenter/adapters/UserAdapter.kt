package com.example.myapplication.presenter.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.domain.model.Post.api.Posts
import com.example.myapplication.domain.model.user.api.User
import com.example.myapplication.presenter.viewHolders.UserViewHolder
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlin.collections.ArrayList

class UserAdapter(private val userList: List<User>, private val postList: List<Posts>) :
    RecyclerView.Adapter<UserViewHolder>(), Filterable {

    var userListFiltered: List<User> = ArrayList<User>(userList)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        //Devolverle al ViewHolder el layout que va a modificar
        val layoutInflater = LayoutInflater.from(parent.context)
        return UserViewHolder(layoutInflater.inflate(R.layout.each_user_item, parent, false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
//        val item = userListFiltered[position] //Necesitamos un List<UsersEntity>
        if (userListFiltered.isEmpty()) Toast.makeText(holder.recyclePost.context, "“List is empty", Toast.LENGTH_SHORT).show()
        holder.render(userListFiltered[position])
        val expanded: Boolean = userListFiltered[position].isExpanded
        holder.subItem.visibility = if (expanded) View.VISIBLE else View.GONE

        holder.recyclePost.layoutManager = LinearLayoutManager(holder.itemView.context)
        holder.recyclePost.setHasFixedSize(true)

        holder.btnVerPublicaciones.setOnClickListener(View.OnClickListener {
            val filteredList: List<Posts> = postList.filter { it.userId == userListFiltered[position].id }
            holder.recyclePost.adapter = PostAdapter(filteredList)
            userListFiltered[position].isExpanded = !expanded
            notifyItemChanged(holder.adapterPosition)
            Log.d("Expanded", userListFiltered[0].isExpanded.toString())
        })
    }

    override fun getItemCount(): Int = userListFiltered.size

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                Log.d("constraint", constraint.toString())
                val charString = constraint.toString().toLowerCase()
//                val charString = "lea"
                if (charString.isEmpty()) {
                    userListFiltered = userList
                } else {
                    val filteredList = ArrayList<User>()
                    userList
                        .filter { it.name.toLowerCase().contains(constraint.toString().toLowerCase()) }.forEach { filteredList.add(it) }
                    if (filteredList.size == 0) {
                        userListFiltered = userList
                    } else {
                        userListFiltered = filteredList
                    }
                }
                return FilterResults().apply { values = userListFiltered }
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults) {
                userListFiltered = if (results.values == null || results.values == "") {
                    ArrayList()
                } else {
                    results.values as ArrayList<User>
                }
                notifyDataSetChanged()
            }
        }
    }
}
