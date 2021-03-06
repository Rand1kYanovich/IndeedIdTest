package com.example.ideentyidtest.model.server

import com.example.ideentyidtest.entity.core.base.BaseResponse
import com.example.ideentyidtest.entity.dto.feed.ImageDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Retrofit2 interface to access Imgur API
 *
 */

interface ImgurApi {
    @GET("/3/gallery/top/top/day/{page}")
    suspend fun getGalleryImages(
        @Path("page") page: Int,
        @Query("showViral") showViral: Boolean,
        @Query("mature") mature: Boolean,
        @Query("album_previews") albumPreviews: Boolean
    ): BaseResponse<List<ImageDTO>>
}