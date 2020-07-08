package com.example.ideentyidtest.model.storage.dao

import androidx.room.*
import com.example.ideentyidtest.entity.core.signup.User

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("SELECT * FROM User WHERE login = :login")
    suspend fun getUser(login: String): User
}