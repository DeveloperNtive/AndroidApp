package com.example.myapplication.domain.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "Address")
data class AddressEntity(
    @ColumnInfo(name = "street") val street: String,
    @ColumnInfo(name = "suite") val suite: String,
    @ColumnInfo(name = "city") val city: String,
    @ColumnInfo(name = "zipcode") val zipcode: String,
    @ColumnInfo(name = "geo") val geo: GeoEntity
)