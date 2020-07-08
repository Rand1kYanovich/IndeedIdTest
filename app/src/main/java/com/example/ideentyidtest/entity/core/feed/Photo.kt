package com.example.ideentyidtest.entity.core.feed

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Photo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val link: String,
    val height: Int,
    val width: Int
)