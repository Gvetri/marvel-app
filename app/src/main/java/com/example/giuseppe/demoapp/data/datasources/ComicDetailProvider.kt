package com.example.giuseppe.demoapp.data.datasources

import com.example.giuseppe.demoapp.data.network.response.ComicListResponse
import com.example.giuseppe.demoapp.data.network.response.ComicResponse
import io.reactivex.Flowable

interface ComicDetailProvider {
    fun getComicDetailData(id: Int): Flowable<ComicResponse?>?
}