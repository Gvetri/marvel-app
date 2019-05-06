package com.example.giuseppe.demoapp.data.network.response

import com.google.gson.annotations.SerializedName

data class ComicListResponse(
    @SerializedName("status")
    val status: String,
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val data: ComicDataResponse
)
