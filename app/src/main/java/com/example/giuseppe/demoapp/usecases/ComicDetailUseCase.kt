package com.example.giuseppe.demoapp.usecases

import com.example.giuseppe.demoapp.data.ComicDetailRepository
import com.example.giuseppe.demoapp.data.network.response.ComicResponse
import io.reactivex.Flowable
import javax.inject.Inject

class ComicDetailUseCase @Inject constructor(val companyDetailRepository : ComicDetailRepository) : BaseUseCase() {

    fun getComicDetailData(id: Int): Flowable<ComicResponse?>? {
        return companyDetailRepository.getData(id)
    }
}