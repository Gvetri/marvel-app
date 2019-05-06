package com.example.giuseppe.demoapp.usecases

import com.example.giuseppe.demoapp.data.MainRepository
import com.example.giuseppe.demoapp.domain.model.ComicDataEntity
import io.reactivex.Flowable
import javax.inject.Inject

class MainUseCase @Inject constructor (val mainRepository : MainRepository) : BaseUseCase() {

    fun getData (offset: Int? = 0) : Flowable<MutableList<ComicDataEntity>>? {
        return mainRepository.getData(offset)
    }

}