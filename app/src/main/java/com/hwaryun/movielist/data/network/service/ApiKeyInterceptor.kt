package com.hwaryun.movielist.data.network.service

import com.hwaryun.movielist.utils.Constants
import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalHttpUrl = originalRequest.url

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter(API_KEY, Constants.API_KEY)
            .build()

        val request = originalRequest.newBuilder()
            .url(url)
            .build()

        return chain.proceed(request)
    }

    companion object {
        private const val API_KEY = "api_key"
    }
}