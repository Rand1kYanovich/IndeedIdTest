package com.example.ideentyidtest.viewmodel.signup

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.ideentyidtest.entity.core.signup.User
import com.example.ideentyidtest.model.interactor.user.UserInteractor
import com.example.ideentyidtest.viewmodel.BaseViewModel
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.lang.Exception

class SignUpViewModel : BaseViewModel(), KoinComponent {

    private val userInteractor: UserInteractor by inject()

    val isUserExist: MutableLiveData<Boolean> = MutableLiveData()

    fun onSignUpBtnClick(login: String) {
        coroutineScope.launch {
            try {
                val user = userInteractor.getUser(login)
                if (user == null) {
                    userInteractor.saveUser(User(login = login))
                    isUserExist.postValue(false)
                } else {
                    isUserExist.postValue(true)
                }
            } catch (e: Exception) {
                Log.e("Error", e.localizedMessage.toString())
            }

        }
    }
}