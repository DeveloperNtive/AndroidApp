package com.example.myapplication.datos.repository.user

import com.example.myapplication.datos.remote.UserService
import com.example.myapplication.domain.database.dao.UserDao
import com.example.myapplication.domain.database.entities.UsersEntity
import com.example.myapplication.domain.model.user.api.User
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val api: UserService,
    private val userDao: UserDao
) {
    //Obtener todos los usuario API O Base De Datos

    //    Obtener usuarios desde API
    suspend fun getAllUsersFromApi(): List<User> {//Se manejara el mismo modelo de datos
        return api.getUsers()
    }

    //Insertar usuarios en base de datos
    fun insertUsers(users: UsersEntity) {//Se manejara el mismo modelo de datos
        userDao.insertUsers(users)
    }


    //    Obtener usuarios desde base de datos
    fun getAllUsersFromDatabase(): UsersEntity {//Se manejara el mismo modelo de datos
        return userDao.getUsers()
    }

    //Borrar usuarios de base de datos
    fun clearUsers() {
        userDao.deleteAllUsers()
    }
}