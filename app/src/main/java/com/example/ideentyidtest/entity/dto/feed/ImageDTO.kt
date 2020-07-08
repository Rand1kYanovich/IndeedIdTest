package com.example.ideentyidtest.entity.dto.feed

import com.example.ideentyidtest.entity.core.feed.ImageItem
import com.google.gson.annotations.SerializedName

data class ImageDTO(
    @SerializedName("id") val id: String,
    @SerializedName("description") val description: String?,
    @SerializedName("score") val score: Int,
    @SerializedName("images") val images: List<ImageInfoDTO>?,
    @SerializedName("cover_width") val coverWidth: Int,
    @SerializedName("cover_height") val coverHeight: Int,
    @SerializedName("ups") val ups: Int,
    @SerializedName("downs") val downs: Int,
    @SerializedName("account_url") val name: String,
    @SerializedName("datetime") val time: Long,
    @SerializedName("views") val views: Int,
    @SerializedName("title") val title: String?
)

fun ImageDTO.toImageItem() = ImageItem(
    this.id,
    this.images?.firstOrNull()?.link ?: "",
    this.coverHeight,
    this.coverWidth
)