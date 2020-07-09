package com.example.ideentyidtest.model.interactor.photo

import com.example.ideentyidtest.entity.core.feed.ImageItem
import com.example.ideentyidtest.entity.core.feed.Photo
import com.example.ideentyidtest.entity.core.feed.toPhoto
import com.example.ideentyidtest.entity.dto.feed.toImageItem
import com.example.ideentyidtest.model.repository.photo.PhotoRepository

/**
 * Business logic and mappers for imgur
 *
 */
class PhotoInteractor(private val photoRepository: PhotoRepository) {

    /**
     * Get,search liked and map images from @[PhotoRepository]
     *
     * @param page - the data paging number
     * @param showViral - Show or hide viral images from the user section
     * @param mature - Show or hide mature images in the response section
     * @param albumPreviews - Include image metadata for gallery posts which are albums
     */
    suspend fun getImages(
        page: Int,
        showViral: Boolean = true,
        mature: Boolean = false,
        albumPreviews: Boolean = false
    ): List<ImageItem> {
        val list = photoRepository.getImages(page, showViral, mature, albumPreviews).map {
            it.toImageItem()
        }
        list.forEach { item ->
            item.isLiked =
                photoRepository.getSavedImages().any { it.link == item.link }
        }
        return list
    }

    /**
     * Get saved images from @[PhotoRepository]
     */
    suspend fun getSavedImages() = photoRepository.getSavedImages()

    /**
     * Delete photo from database from @[PhotoRepository]
     *
     * @param photo - deleted photo
     */

    suspend fun deleteImage(photo: Photo) = photoRepository.deleteImage(photo)

    /**
     * Insert photo from database from @[PhotoRepository]
     *
     * @param imageItem - inserted image item
     */
    suspend fun insertImage(imageItem: ImageItem) =
        photoRepository.insertImage(imageItem.toPhoto())
}