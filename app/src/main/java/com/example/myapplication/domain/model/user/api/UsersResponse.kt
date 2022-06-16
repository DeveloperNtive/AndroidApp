package com.example.myapplication.domain.model.user.api

import com.google.gson.annotations.SerializedName

data class UsersResponse(
    @SerializedName("users")
    var users: List<User>
)