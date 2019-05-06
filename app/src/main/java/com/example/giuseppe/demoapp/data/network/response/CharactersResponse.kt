package com.example.giuseppe.demoapp.data.network.response

import com.google.gson.annotations.SerializedName


data class CharactersResponse(
    @SerializedName("available")
    val available: Int,
    @SerializedName("collectionURI")
    val collectionURI: String? = null,
    @SerializedName("items")
    val items: List<ComicCharacterResponse>? = null,
    @SerializedName("returned")
    val returned: Int? = null
)