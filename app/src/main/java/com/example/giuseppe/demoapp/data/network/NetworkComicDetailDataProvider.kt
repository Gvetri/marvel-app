package com.example.giuseppe.demoapp.data.network

import com.example.giuseppe.demoapp.BuildConfig
import com.example.giuseppe.demoapp.data.datasources.ComicDetailProvider
import com.example.giuseppe.demoapp.data.network.response.ComicListResponse
import com.example.giuseppe.demoapp.data.network.response.ComicResponse
import com.example.giuseppe.demoapp.network.ApiService
import com.example.giuseppe.demoapp.utils.HashCalculator
import io.reactivex.Flowable
import javax.inject.Inject

class NetworkComicDetailDataProvider @Inject constructor(var apiService: ApiService) : ComicDetailProvider {
    override fun getComicDetailData(id: Int): Flowable<ComicResponse?>? {
        val timeStamp = System.currentTimeMillis().toString()
        val hash = HashCalculator().calculate(listOf(timeStamp, BuildConfig.PRIVATE_KEY, BuildConfig.PUBLIC_KEY))
        if (hash.isNullOrEmpty()) return Flowable.empty()
        return apiService.getComics(id, timeStamp, BuildConfig.PUBLIC_KEY, hash).map { it.data.results.firstOrNull()}
    }
}