package com.example.giuseppe.demoapp.data.network.response

import com.google.gson.annotations.SerializedName

data class ComicDataResponse(
    @SerializedName("count")
    var count: Int,
    @SerializedName("total")
    var total: Int,
    @SerializedName("results")
    var results: List<ComicResponse>,
    @SerializedName("offset")
    val offset: Int
)