package com.example.giuseppe.demoapp.data.network.response

import com.google.gson.annotations.SerializedName

data class ImageResponse(
    @SerializedName("path")
    var path: String,
    @SerializedName("extension")
    var extension: String
)