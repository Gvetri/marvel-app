package com.example.giuseppe.demoapp.data

import com.example.giuseppe.demoapp.data.datasources.MainProvider
import com.example.giuseppe.demoapp.domain.model.ComicDataEntity
import io.reactivex.Flowable
import javax.inject.Inject

class MainRepository @Inject constructor(var mainProvider: MainProvider){

   fun getData(offset: Int? = 0): Flowable<MutableList<ComicDataEntity>>? {
        return mainProvider.getData(offset)
    }

}

