package com.example.ideentyidtest.model.storage.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.ideentyidtest.entity.core.feed.ImageItem
import com.example.ideentyidtest.entity.core.feed.Photo
import com.example.ideentyidtest.entity.core.signup.User

interface PhotoDao {
    @Insert
    suspend fun insertPhoto(user: Photo)

    @Update
    suspend fun updatePhoto(user: Photo)

    @Delete
    suspend fun deletePhoto(photo: Photo)

    @Query("SELECT * FROM Photo")
    suspend fun getAllPhoto(): List<Photo>
}