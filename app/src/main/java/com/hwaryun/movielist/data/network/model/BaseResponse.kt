package com.hwaryun.movielist.data.network.model

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(

    @SerializedName("results")
    val results: List<T>
)