package com.example.ideentyidtest.model.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ideentyidtest.entity.core.feed.Photo
import com.example.ideentyidtest.entity.core.signup.User
import com.example.ideentyidtest.model.storage.dao.PhotoDao
import com.example.ideentyidtest.model.storage.dao.UserDao

@Database(
    entities = [User::class, Photo::class],
    version = 2
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun photoDao(): PhotoDao

}