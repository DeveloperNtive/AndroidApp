package com.example.myapplication.domain.repository

//import com.example.myapplication.domain.database.entities.UsersEntity
import com.example.myapplication.domain.model.user.api.User
//import com.example.myapplication.domain.model.user.api.Users
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface UserApiClient {
    //    Obtenemos todos los usuario desde la api
    @GET
    suspend fun getUsers(@Url url:String): Response<List<User>>
}
