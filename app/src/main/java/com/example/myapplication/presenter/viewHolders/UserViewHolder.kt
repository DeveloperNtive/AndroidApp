package com.example.myapplication.presenter.viewHolders

import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.domain.model.user.api.User

class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val userName = view.findViewById<TextView>(R.id.userName)
    val userPhone = view.findViewById<TextView>(R.id.userPhone)
    val userEmail = view.findViewById<TextView>(R.id.userEmail)
    val btnVerPublicaciones = view.findViewById<TextView>(R.id.btnVerPublicaciones)
    val recyclePost = view.findViewById<RecyclerView>(R.id.recyclePost)
    val subItem = view.findViewById<RelativeLayout>(R.id.subItem)

    fun render(user: User) {

        val expanded: Boolean = user.isExpanded

        subItem.visibility = if (expanded) View.VISIBLE else View.GONE

        userName.text = user.name
        userPhone.text = user.phone
        userEmail.text = user.email
    }
}