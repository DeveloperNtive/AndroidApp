package com.example.myapplication.domain.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication.domain.model.user.api.User

@Entity(tableName = "Users_Table")
class UsersEntity(
    var user: List<User>
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}