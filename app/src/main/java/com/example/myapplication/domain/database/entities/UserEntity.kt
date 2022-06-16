package com.example.myapplication.domain.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication.domain.model.user.User

@Entity(tableName = "Users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0, //Primary key
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "username") val username: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "address") val address: AddressEntity, //Address
    @ColumnInfo(name = "phone") val phone: String,
    @ColumnInfo(name = "website") val website: String,
    @ColumnInfo(name = "company") val company: CompanyEntity //Company
)

fun User.toDatabase() = UserEntity(
    name = name,
    username = username,
    email = email,
    address = AddressEntity(
        street = "",
        suite = "",
        city = "",
        zipcode = "",
        GeoEntity(
            lat = "",
            lng = ""
        )
    ),
    phone = phone,
    website = website,
    company = CompanyEntity(
        name = "",
        catchPhrase = "",
        bs = ""
    )
)
