package com.example.ideentyidtest.viewmodel.signup

import androidx.lifecycle.MutableLiveData
import com.example.ideentyidtest.model.interactor.user.UserInteractor
import com.example.ideentyidtest.viewmodel.BaseViewModel
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class SignUpViewModel : BaseViewModel(), KoinComponent {

    private val userInteractor: UserInteractor by inject()

    val isUserExist: MutableLiveData<Boolean> = MutableLiveData()

    fun onSignUpBtnClick(login: String) {
        coroutineScope.launch {
            val user = userInteractor.getUser(login)
            isUserExist.postValue(user != null)
        }
    }
}