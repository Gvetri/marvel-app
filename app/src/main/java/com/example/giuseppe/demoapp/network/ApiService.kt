package com.example.giuseppe.demoapp.network

import com.example.giuseppe.demoapp.data.network.response.ComicListResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("comics")
    fun getComicList(
        @Query("format") format : String? = "digital comic",
        @Query("limit") limit: Long,
        @Query("ts") timeStamp: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("offset") offset: Int? = 0
    ): Flowable<ComicListResponse>

    @GET("comics/{comicId}")
    fun getComics(
        @Path("comicId") id: Int,
        @Query("ts") timeStamp: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): Flowable<ComicListResponse>

}
