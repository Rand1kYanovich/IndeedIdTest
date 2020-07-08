package com.example.ideentyidtest.ui.pagination

import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.example.ideentyidtest.entity.core.feed.ImageItem
import com.example.ideentyidtest.model.interactor.photo.PhotoInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FeedDataSource(
    private val photoInteractor: PhotoInteractor,
    private val coroutineScope: CoroutineScope
) : PageKeyedDataSource<Int, ImageItem>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, ImageItem>
    ) {
        coroutineScope.launch {
            val listImages = photoInteractor.getImages(0)
            withContext(Dispatchers.Main) {
                callback.onResult(listImages, null, 1)
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, ImageItem>) {
        coroutineScope.launch {
            val listImages = photoInteractor.getImages(params.key)
            withContext(Dispatchers.Main) {
                callback.onResult(listImages, params.key + 1)
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, ImageItem>) {
        coroutineScope.launch {
            val listImages = photoInteractor.getImages(params.key)
            withContext(Dispatchers.Main) {
                callback.onResult(listImages, params.key - 1)
            }
        }
    }

    class Factory(
        private val photoInteractor: PhotoInteractor,
        private val coroutineScope: CoroutineScope
    ) : DataSource.Factory<Int, ImageItem>() {
        override fun create(): DataSource<Int, ImageItem> {
            return FeedDataSource(photoInteractor, coroutineScope)
        }
    }
}