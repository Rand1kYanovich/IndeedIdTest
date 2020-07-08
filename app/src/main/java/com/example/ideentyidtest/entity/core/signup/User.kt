package com.example.ideentyidtest.entity.core.signup

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val login: String,
    val password: String
)