package com.hwaryun.movielist.utils.wrapper

sealed class DataResource<T>(
    val payload: T? = null,
    val message: String? = null,
    val exception: Throwable? = null,
) {
    class Success<T>(data: T) : DataResource<T>(data)
    class Error<T>(exception: Throwable?, data: T? = null) : DataResource<T>(data, exception = exception)
}
