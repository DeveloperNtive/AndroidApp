package com.example.myapplication.domain.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "Company")
data class CompanyEntity(
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "catchPhrase") val catchPhrase: String,
    @ColumnInfo(name = "bs") val bs: String
)
