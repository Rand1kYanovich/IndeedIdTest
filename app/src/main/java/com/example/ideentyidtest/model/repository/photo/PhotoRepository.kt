package com.example.ideentyidtest.model.repository.photo

import com.example.ideentyidtest.entity.core.feed.Photo
import com.example.ideentyidtest.model.repository.BaseRepository
import com.example.ideentyidtest.model.server.ImgurApi
import com.example.ideentyidtest.model.storage.AppDatabase

class PhotoRepository(private val api: ImgurApi, private val db: AppDatabase) : BaseRepository() {
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

    /**
     * Get all saved photo from database
     */
    suspend fun getSavedImages() = db.photoDao().getAllPhoto()

    /**
     * Delete photo from database
     *
     * @param photo - deleted photo
     */
    suspend fun deleteImage(photo: Photo) = db.photoDao().deletePhoto(photo)

    /**
     * Insert photo from database
     *
     * @param photo - inserted photo
     */
    suspend fun insertImage(photo: Photo) = db.photoDao().insertPhoto(photo)
}