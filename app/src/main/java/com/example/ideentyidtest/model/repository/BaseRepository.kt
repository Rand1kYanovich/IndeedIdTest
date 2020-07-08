package com.example.ideentyidtest.model.repository

import com.example.ideentyidtest.entity.core.base.BaseResponse
import java.lang.Exception

open class BaseRepository {

    suspend fun <T : Any> apiCall(call: suspend () -> BaseResponse<T>): T {
        try {
            val response = call.invoke()
            val body = response.data

            when (response.status) {
                STATUS_SUCCESS -> return body
                else -> throw Throwable()
            }
        } catch (e: Exception) {
            throw e
        }
    }

    companion object {
        private const val STATUS_SUCCESS = 200
    }
}