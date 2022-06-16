package com.example.myapplication.datos.repository.user

import com.example.myapplication.domain.model.user.api.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserProvider @Inject constructor() {
    var users: List<User> = emptyList()
}