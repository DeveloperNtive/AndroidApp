package com.example.myapplication.domain.database.dao

import androidx.room.*
import com.example.myapplication.domain.database.entities.UsersEntity

//import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    //    INSERT
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(users: UsersEntity)

    //    SELECT
    @Query("SELECT * FROM Users_Table ORDER BY ID ASC")
    fun getUsers(): UsersEntity

    //    DELETE
    @Query("DELETE FROM Users_Table")
    fun deleteAllUsers()

//    //    SELECT
//    @Query("Select * FROM Users")
//    fun getAllUsers(): List<UserEntity>
//
//    //    SELECT BY ID
//    @Query("SELECT * FROM Users WHERE name = :name")
//    fun getUserById(name: String): UserEntity

}