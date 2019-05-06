package com.example.giuseppe.demoapp.data.network.response

import com.google.gson.annotations.SerializedName

data class ComicDateResponse(
    @SerializedName("type")
    private val type: String,
    @SerializedName("date")
    private val date: String
)