package com.example.ideentyidtest.viewmodel.feed

import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.ideentyidtest.entity.core.feed.ImageItem
import com.example.ideentyidtest.model.interactor.photo.PhotoInteractor
import com.example.ideentyidtest.ui.pagination.FeedDataSource
import com.example.ideentyidtest.viewmodel.BaseViewModel
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class FeedViewModel : BaseViewModel(), KoinComponent {

    private val interactor: PhotoInteractor by inject()

    val feedList: MutableLiveData<PagedList<ImageItem>> = MutableLiveData()

    init {
        getImages()
    }

    private fun getImages() {
        val pagedListLiveData =
            LivePagedListBuilder(
                FeedDataSource.Factory(interactor, coroutineScope), PagedList
                    .Config
                    .Builder()
                    .setPageSize(40)
                    .setPrefetchDistance(3)
                    .setEnablePlaceholders(false)
                    .build()
            ).build()
        pagedListLiveData.observeForever {
            feedList.postValue(it)
        }
    }

    fun onHearBtnClick(imageItem: ImageItem) {
        coroutineScope.launch {
            interactor.insertImage(imageItem)
        }
    }
}