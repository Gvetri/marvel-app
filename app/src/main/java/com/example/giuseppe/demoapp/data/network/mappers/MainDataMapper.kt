package com.example.giuseppe.demoapp.data.network.mappers

import com.example.giuseppe.demoapp.data.network.response.ComicResponse
import com.example.giuseppe.demoapp.domain.model.ComicDataEntity
import io.reactivex.Flowable


class MainDataMapper : Mapper<Flowable<MutableList<ComicResponse>>,Flowable<MutableList<ComicDataEntity>>> {


    override fun map(entry: Flowable<MutableList<ComicResponse>>): Flowable<MutableList<ComicDataEntity>>? {
        return null
    }

}