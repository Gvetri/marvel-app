package com.example.giuseppe.demoapp.data.network.response

import com.google.gson.annotations.SerializedName

class ComicCreatorResponse(
    @SerializedName("available")
    private val available: Int,
    @SerializedName("collectionURI")
    private val collectionUri: String,
    @SerializedName("items")
    private val items: List<CreatorSummaryResponse>
)