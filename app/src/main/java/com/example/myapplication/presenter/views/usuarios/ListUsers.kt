package com.example.myapplication.presenter.views.usuarios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityListarUsuariosBinding
import com.example.myapplication.domain.model.Post.api.Posts
import com.example.myapplication.domain.model.user.api.User
import com.example.myapplication.presenter.adapters.UserAdapter
import com.example.myapplication.presenter.viewModels.UsersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListUsers : AppCompatActivity() {

    //    Variables globales
    private lateinit var binding: ActivityListarUsuariosBinding
    private val userViewModel: UsersViewModel by viewModels()

    var adapter: UserAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Binding
        binding = ActivityListarUsuariosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userViewModel.onCreate() //Nos trae la informacion ya sea de base de datos o de la API
        userViewModel.dataListUsers.observe(this, Observer { userlist ->
            userViewModel.dataListPosts.observe(this, Observer { postList ->
                initRecycleView(userlist, postList)//Se la pasamos al recycleView

            })
        })

        binding.countrySearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                adapter?.filter?.filter(newText)
                return false
            }

        })
    }

    private fun initRecycleView(listUsers: List<User>, listPosts: List<Posts>) {
        val recyclerView = binding.recyclerUser
        adapter = UserAdapter(listUsers, listPosts)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
    }
}