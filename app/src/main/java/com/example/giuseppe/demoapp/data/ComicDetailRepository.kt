package com.example.giuseppe.demoapp.data

import com.example.giuseppe.demoapp.data.datasources.ComicDetailProvider
import com.example.giuseppe.demoapp.data.network.response.ComicResponse
import io.reactivex.Flowable
import javax.inject.Inject

class ComicDetailRepository @Inject constructor(var companyDetailProvider: ComicDetailProvider) {

    fun getData(id: Int): Flowable<ComicResponse?>? {
        return companyDetailProvider.getComicDetailData(id)
    }

}