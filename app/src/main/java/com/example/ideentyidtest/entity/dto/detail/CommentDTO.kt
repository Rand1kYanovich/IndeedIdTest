package com.example.ideentyidtest.entity.dto.detail

import com.google.gson.annotations.SerializedName

data class CommentDTO(
    @SerializedName("author") val author: String,
    @SerializedName("comment") val comment: String,
    @SerializedName("datetime") val datetime: Long,
    @SerializedName("children") val children: List<CommentDTO>,
    @SerializedName("ups") val ups: Int
)