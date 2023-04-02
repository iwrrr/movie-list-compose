package com.hwaryun.movielist.data.repository

import com.hwaryun.movielist.utils.exception.NoInternetConnectionException
import com.hwaryun.movielist.utils.wrapper.DataResource
import retrofit2.HttpException
import java.io.IOException

abstract class BaseRepository {

    suspend fun <T> safeNetworkCall(apiCall: suspend () -> T): DataResource<T> {
        return try {
            DataResource.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException -> DataResource.Error(NoInternetConnectionException("No Internet Connection"))
                is HttpException -> {
                    DataResource.Error(throwable)
                }
                else -> {
                    DataResource.Error(throwable)
                }
            }
        }
    }
}