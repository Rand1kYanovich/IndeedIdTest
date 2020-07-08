package com.example.ideentyidtest.viewmodel.savedphoto

import androidx.lifecycle.MutableLiveData
import com.example.ideentyidtest.entity.core.feed.Photo
import com.example.ideentyidtest.model.interactor.photo.PhotoInteractor
import com.example.ideentyidtest.viewmodel.BaseViewModel
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class SavedPhotoViewModel : BaseViewModel(), KoinComponent {

    private val interactor: PhotoInteractor by inject()

    val listSavedImages: MutableLiveData<MutableList<Photo>> = MutableLiveData()

    init {
        getSavedImages()
    }

    private fun getSavedImages() {
        coroutineScope.launch {
            if (listSavedImages.value == null) {
                val list = interactor.getSavedImages()
                listSavedImages.postValue(list.toMutableList())
            }
        }
    }

    fun onDeleteBtnClick(photo: Photo) {
        coroutineScope.launch {
            listSavedImages.value?.remove(photo)
            interactor.deleteImage(photo)
        }
    }
}