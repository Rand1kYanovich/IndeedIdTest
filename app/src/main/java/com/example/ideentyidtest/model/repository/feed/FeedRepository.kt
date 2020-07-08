package com.example.ideentyidtest.model.repository.feed

import com.example.ideentyidtest.model.repository.BaseRepository
import com.example.ideentyidtest.model.server.ImgurApi

class FeedRepository(private val api: ImgurApi) : BaseRepository() {
    /**
     * Get images from network request
     *
     * @param page - the data paging number
     * @param showViral - Show or hide viral images from the user section
     * @param mature - Show or hide mature images in the response section
     * @param albumPreviews - Include image metadata for gallery posts which are albums
     */
    suspend fun getImages(page: Int, showViral: Boolean, mature: Boolean, albumPreviews: Boolean) =
        apiCall { api.getGalleryImages(page, showViral, mature, albumPreviews) }

    /**
     * Get detail info about current image from network request
     *
     * @param id - image hash
     */
    suspend fun getDetailImage(id: String) =
        apiCall { api.getDetailImage(id) }

    /**
     * Get best comments from network request
     *
     * @param id - image hash
     */
    suspend fun getComments(id: String) =
        apiCall { api.getComments(id) }
}