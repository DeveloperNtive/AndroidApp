package com.example.myapplication.domain.model.user

import com.example.myapplication.domain.database.entities.UserEntity
import com.example.myapplication.domain.model.user.api.Address
import com.example.myapplication.domain.model.user.api.Company
import com.example.myapplication.domain.model.user.api.Geo

data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company
)

fun UserEntity.toEntity() = User(
    id,
    name,
    username,
    email,
    Address(street = "", suite = "", city = "", zipcode = "", Geo(lat = "", lng = "")),
    phone,
    website,
    Company(name, catchPhrase = "", bs = "")
)
