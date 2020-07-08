package com.example.ideentyidtest.entity.dto.feed

import com.google.gson.annotations.SerializedName

data class ImageInfoDTO(
    @SerializedName("link") val link: String?,
    @SerializedName("description") val description: String?
)