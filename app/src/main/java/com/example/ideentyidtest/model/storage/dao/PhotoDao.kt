package com.example.ideentyidtest.model.storage.dao

import androidx.room.*
import com.example.ideentyidtest.entity.core.feed.ImageItem
import com.example.ideentyidtest.entity.core.feed.Photo
import com.example.ideentyidtest.entity.core.signup.User

@Dao
interface PhotoDao {
    @Insert
    suspend fun insertPhoto(photo: Photo)

    @Update
    suspend fun updatePhoto(photo: Photo)

    @Delete
    suspend fun deletePhoto(photo: Photo)

    @Query("SELECT * FROM Photo")
    suspend fun getAllPhoto(): List<Photo>
}