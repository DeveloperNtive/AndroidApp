package com.example.myapplication.domain.model.user.api

data class User(
    var isExpanded: Boolean = true,
    val id: String,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company
)