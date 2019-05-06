package com.example.giuseppe.demoapp.domain.model

import com.example.giuseppe.demoapp.data.network.response.ComicCreatorResponse
import com.example.giuseppe.demoapp.data.network.response.ComicDateResponse
import com.example.giuseppe.demoapp.data.network.response.ComicPriceResponse
import com.example.giuseppe.demoapp.data.network.response.ImageResponse
import com.google.gson.annotations.SerializedName

data class ComicDataEntity(
    @SerializedName("digitalId")
    var digitalId: Int = 0,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("description")
    var description: String?,
    @SerializedName("pageCount")
    var pageCount: String?,
    @SerializedName("thumbnail")
    var thumbnail: ImageResponse?,
    @SerializedName("images")
    var images: List<ImageResponse>?,
    @SerializedName("prices")
    var prices: List<ComicPriceResponse>?,
    @SerializedName("creators")
    var creators: ComicCreatorResponse?,
    @SerializedName("dates")
    var dates: List<ComicDateResponse>?,
    var offset: Int = 0
)