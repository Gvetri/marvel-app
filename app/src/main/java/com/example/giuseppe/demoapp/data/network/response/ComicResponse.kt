package com.example.giuseppe.demoapp.data.network.response

import com.google.gson.annotations.SerializedName

data class ComicResponse(
    @SerializedName("digitalId")
    var digitalId: Int,
    @SerializedName("id")
    var id: Int,
    @SerializedName("title")
    var title: String,
    @SerializedName("description")
    var description: String,
    @SerializedName("pageCount")
    var pageCount: String,
    @SerializedName("thumbnail")
    var thumbnail: ImageResponse,
    @SerializedName("images")
    var images: List<ImageResponse>,
    @SerializedName("prices")
    var prices: List<ComicPriceResponse>,
    @SerializedName("creators")
    var creators: ComicCreatorResponse,
    @SerializedName("dates")
    var dates: List<ComicDateResponse>,
    @SerializedName("characters")
    var characters : CharactersResponse
)