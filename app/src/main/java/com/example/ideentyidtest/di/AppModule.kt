package com.example.ideentyidtest.di

import androidx.room.Room
import com.example.ideentyidtest.model.interactor.photo.PhotoInteractor
import com.example.ideentyidtest.model.interactor.user.UserInteractor
import com.example.ideentyidtest.model.repository.photo.PhotoRepository
import com.example.ideentyidtest.model.repository.user.UserRepository
import com.example.ideentyidtest.model.storage.AppDatabase
import com.example.ideentyidtest.model.storage.migration.MIGRATION_1_2
import com.example.ideentyidtest.viewmodel.feed.FeedViewModel
import com.example.ideentyidtest.viewmodel.savedphoto.SavedPhotoViewModel
import com.example.ideentyidtest.viewmodel.signin.SignInViewModel
import com.example.ideentyidtest.viewmodel.signup.SignUpViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import java.security.KeyStore

val appModule = module {

    //DB
    single {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, "imgur_db")
            .addMigrations(MIGRATION_1_2)
            .build()
    }

    //User
    factory { UserRepository(get()) }
    factory { UserInteractor(get()) }

    //SignUp
    viewModel { SignUpViewModel() }

    //SignIn
    viewModel { SignInViewModel() }

    //Photo
    factory { PhotoRepository(get(), get()) }
    factory {
        PhotoInteractor(
            get()
        )
    }


    //Feed
    viewModel { FeedViewModel() }

    //SavedPhoto
    viewModel { SavedPhotoViewModel() }

}