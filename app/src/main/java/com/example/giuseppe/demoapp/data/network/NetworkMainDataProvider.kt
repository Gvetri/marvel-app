package com.example.giuseppe.demoapp.data.network

import com.example.giuseppe.demoapp.BuildConfig
import com.example.giuseppe.demoapp.data.datasources.MainProvider
import com.example.giuseppe.demoapp.data.network.mappers.MainDataMapper
import com.example.giuseppe.demoapp.domain.model.ComicDataEntity
import com.example.giuseppe.demoapp.data.network.response.ComicListResponse
import com.example.giuseppe.demoapp.data.network.response.ComicResponse
import com.example.giuseppe.demoapp.network.ApiService
import com.example.giuseppe.demoapp.utils.HashCalculator
import io.reactivex.Flowable
import javax.inject.Inject

class NetworkMainDataProvider @Inject constructor(var apiService: ApiService, var dataMapper: MainDataMapper) :
    MainProvider {

    /***
     * returns a list of comic filtered by digitalId
     */
    override fun getData(offset: Int?): Flowable<MutableList<ComicDataEntity>>? {
        val timeStamp = getTimeStamp()
        val hash = getHash(timeStamp)
        if (hash.isNullOrEmpty()) return Flowable.empty()
        return getComicList(timeStamp, hash, offset)
    }

    private fun getHash(timeStamp: String): String? {
        return HashCalculator().calculate(listOf(timeStamp, BuildConfig.PRIVATE_KEY, BuildConfig.PUBLIC_KEY))
    }

    private fun getTimeStamp(): String {
        return System.currentTimeMillis().toString()
    }

    private fun getComicList(timeStamp: String, hash: String, offset: Int?): Flowable<MutableList<ComicDataEntity>>? {
        return apiService.getComicList(limit = 100,timeStamp = timeStamp, apiKey = BuildConfig.PUBLIC_KEY, hash = hash, offset = offset)
            .map { t: ComicListResponse ->
                t.data.results.map { result: ComicResponse ->
                    ComicDataEntity(
                        result.digitalId,
                        result.id,
                        result.title,
                        result.description,
                        result.pageCount,
                        result.thumbnail,
                        result.images,
                        result.prices,
                        result.creators,
                        result.dates,
                        t.data.offset
                    )
                }
            }
            .flatMap { Flowable.fromIterable(it) }
            .filter { it.digitalId != 0 }
            .toList()
            .onErrorReturnItem(emptyList())
            .toFlowable()
    }

}