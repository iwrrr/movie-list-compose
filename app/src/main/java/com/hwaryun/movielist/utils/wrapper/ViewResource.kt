package com.hwaryun.movielist.utils.wrapper

sealed class ViewResource<T>(
    val payload: T? = null,
    val message: String? = null,
    val exception: Throwable? = null,
) {
    class Success<T>(data: T) : ViewResource<T>(data)
    class Error<T>(exception: Throwable?, data: T? = null) : ViewResource<T>(data, exception = exception)
    class Empty<T>(data: T? = null, msg: String? = null) : ViewResource<T>(data)
    class Loading<T>(data: T? = null) : ViewResource<T>(data)
}
