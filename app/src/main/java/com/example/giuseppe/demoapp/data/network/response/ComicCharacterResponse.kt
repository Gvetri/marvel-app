package com.example.giuseppe.demoapp.data.network.response

import com.google.gson.annotations.SerializedName

data class ComicCharacterResponse(
    @SerializedName("resourceURI")
    val resourceUri: String,
    @SerializedName("name")
    val name: String? = null
) {
}