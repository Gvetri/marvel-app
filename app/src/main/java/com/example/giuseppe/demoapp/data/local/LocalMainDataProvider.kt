package com.example.giuseppe.demoapp.data.local

import com.example.giuseppe.demoapp.data.datasources.MainProvider
import com.example.giuseppe.demoapp.domain.model.ComicDataEntity
import io.reactivex.Flowable

class LocalMainDataProvider : MainProvider {
    override fun getData(offset: Int?): Flowable<MutableList<ComicDataEntity>>? {
        return Flowable.empty()
    }
}