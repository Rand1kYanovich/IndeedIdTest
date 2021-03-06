package com.example.ideentyidtest

import android.app.Application
import com.example.ideentyidtest.di.appModule
import com.example.ideentyidtest.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    appModule, networkModule
                )
            )
        }

    }
}