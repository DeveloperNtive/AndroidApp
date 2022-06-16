package com.example.myapplication.datos.remote

import com.example.myapplication.domain.model.user.api.User
import com.example.myapplication.domain.repository.UserApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class UserService @Inject constructor(
    private val api: UserApiClient
) {
    suspend fun getUsers(): List<User> {
        return withContext(Dispatchers.IO) {//Ejecutamos lo siguiente en un hilo nuevo con corrutina
            val response: Response<List<User>> = api.getUsers("/users")//Consumimos el api
            response.body()!! //y luego lo retornamos
        }
    }
}