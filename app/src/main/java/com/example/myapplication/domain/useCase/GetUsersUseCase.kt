package com.example.myapplication.domain.useCase

import com.example.myapplication.datos.repository.user.UserRepository
import com.example.myapplication.domain.database.entities.UsersEntity
import com.example.myapplication.domain.model.user.api.User
import javax.inject.Inject


class GetUsersUseCase @Inject constructor(
    val repository: UserRepository
) {
    suspend operator fun invoke(): List<User> {
        val users = repository.getAllUsersFromApi()//Recupero usuarios desde API
        repository.clearUsers()
        repository.insertUsers(UsersEntity(users))
        return repository.getAllUsersFromDatabase().user
//        return users
    }
}