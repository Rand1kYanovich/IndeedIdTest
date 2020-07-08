package com.example.ideentyidtest.entity.core.feed

data class ImageItem(
    val id: String,
    val link: String,
    val height: Int,
    val width: Int,
    var isLiked: Boolean = false
)

fun ImageItem.toPhoto() = Photo(
    link = this.link,
    height = this.height,
    width = this.width
)