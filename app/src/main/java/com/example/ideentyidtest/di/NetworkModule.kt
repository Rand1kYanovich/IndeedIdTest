package com.example.ideentyidtest.di

import android.content.Context
import com.example.ideentyidtest.BuildConfig.BASE_URL
import com.example.ideentyidtest.model.server.ImgurApi
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    factory { provideDefaultOkhttpClient(androidContext()) }
    single { provideImgurApi(provideRetrofit(androidContext(), BASE_URL)) }
}

fun provideDefaultOkhttpClient(contex: Context): OkHttpClient.Builder {
    return OkHttpClient.Builder()
        .addInterceptor { chain ->
            val newBuilder = chain.request().newBuilder()
            newBuilder.addHeader("Authorization", "Client-ID e8b426c7ef8afab")

            return@addInterceptor chain.proceed(newBuilder.build())
        }
        .readTimeout(90, TimeUnit.SECONDS)
        .connectTimeout(90, TimeUnit.SECONDS)
}

fun provideRetrofit(contex: Context, baseUrl: String): Retrofit {
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(provideDefaultOkhttpClient(contex).build())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideImgurApi(retrofit: Retrofit): ImgurApi =
    retrofit.create(ImgurApi::class.java)