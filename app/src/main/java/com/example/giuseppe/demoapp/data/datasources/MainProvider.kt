package com.example.giuseppe.demoapp.data.datasources

import com.example.giuseppe.demoapp.domain.model.ComicDataEntity
import io.reactivex.Flowable

interface MainProvider {
    fun getData(offset: Int? = 0): Flowable<MutableList<ComicDataEntity>>?
}