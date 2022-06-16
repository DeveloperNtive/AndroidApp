package com.example.myapplication.domain.database

import androidx.room.TypeConverter
import com.example.myapplication.domain.model.user.api.Address
import com.example.myapplication.domain.model.user.api.Company
import com.example.myapplication.domain.model.user.api.User
import com.example.myapplication.domain.model.user.api.UsersResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class UsersTypeConverter {

    private val gson =  Gson()

    @TypeConverter
    fun userResponseToString(usersResponse: List<User>): String {
        return gson.toJson(usersResponse)
    }

    @TypeConverter
    fun stringToUserResponse(userString: String): List<User> {
        val objectType = object : TypeToken<List<User>>() {}.type
        return gson.fromJson(userString, objectType)
    }

    @TypeConverter
    fun addressToString(usersResponse: Address): String {
        return gson.toJson(usersResponse)
    }

    @TypeConverter
    fun stringToAddress(userString: String): Address {
        val objectType = object : TypeToken<Address>() {}.type
        return gson.fromJson(userString, objectType)
    }

    @TypeConverter
    fun companyToString(usersResponse: Company): String {
        return gson.toJson(usersResponse)
    }

    @TypeConverter
    fun stringToCompany(userString: String): Company {
        val objectType = object : TypeToken<Company>() {}.type
        return gson.fromJson(userString, objectType)
    }

}