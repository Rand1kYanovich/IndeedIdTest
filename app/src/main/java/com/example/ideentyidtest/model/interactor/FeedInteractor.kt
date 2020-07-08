package com.example.ideentyidtest.model.interactor

import com.example.ideentyidtest.entity.dto.feed.toImageItem
import com.example.ideentyidtest.model.repository.BaseRepository
import com.example.ideentyidtest.model.repository.feed.FeedRepository

/**
 * Business logic and mappers for imgur
 *
 */
class FeedInteractor(private val feedRepository: FeedRepository) {

    /**
     * Get and map images from @[FeedRepository]
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
    ) =
        feedRepository.getImages(page, showViral, mature, albumPreviews).map {
            it.toImageItem()
        }


    /**
     * Get and map detail image from @[FeedRepository]
     *
     * @param id - image hash
     */
    suspend fun getDetailImage(id: String) = feedRepository.getDetailImage(id).toImageItem()

    /**
     * Get and map best comments from @[FeedRepository]
     *
     * @param id - image hash
     */
    suspend fun getBestComments(id: String) = feedRepository.getComments(id)
}