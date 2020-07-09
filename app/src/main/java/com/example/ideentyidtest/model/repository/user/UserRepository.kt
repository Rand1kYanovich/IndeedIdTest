package com.example.ideentyidtest.model.repository.user

import com.example.ideentyidtest.entity.core.signup.User
import com.example.ideentyidtest.model.repository.BaseRepository
import com.example.ideentyidtest.model.storage.AppDatabase

class UserRepository(private val db: AppDatabase) : BaseRepository() {

    /**
     * get user from Database
     *
     * @param login = user login
     */
    suspend fun getUser(login: String) = db.userDao().getUser(login)


    /**
     * Save user to Database
     *
     * @param user = saved user
     */
    suspend fun saveUser(user: User) = db.userDao().insertUser(user)
}