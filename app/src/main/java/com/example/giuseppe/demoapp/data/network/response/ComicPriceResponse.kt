package com.example.giuseppe.demoapp.data.network.response

import com.google.gson.annotations.SerializedName

data class ComicPriceResponse(
    @SerializedName("type")
    val type: String,
    @SerializedName("price")
    val price: Double
)