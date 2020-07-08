package com.example.ideentyidtest.entity.core.base

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("data") val data: T,
    @SerializedName("success") val success: Boolean,
    @SerializedName("status") val status: Int
)