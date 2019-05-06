package com.example.giuseppe.demoapp.data.network.response

import com.google.gson.annotations.SerializedName

data class CreatorSummaryResponse(
    @SerializedName("name")
    private val name: String,
    @SerializedName("role")
    private val role: String,
    @SerializedName("resourceURI")
    private val resourceUri: String
)