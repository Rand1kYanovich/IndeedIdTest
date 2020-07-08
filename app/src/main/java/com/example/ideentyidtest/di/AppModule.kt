package com.example.ideentyidtest.di

import com.example.ideentyidtest.model.interactor.FeedInteractor
import com.example.ideentyidtest.model.repository.feed.FeedRepository
import com.example.ideentyidtest.viewmodel.feed.FeedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    //DB


    //Feed
    factory { FeedRepository(get()) }
    factory { FeedInteractor(get()) }
    viewModel { FeedViewModel() }

}