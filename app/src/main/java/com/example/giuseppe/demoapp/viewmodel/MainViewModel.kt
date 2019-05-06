package com.example.giuseppe.demoapp.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.example.giuseppe.demoapp.domain.model.ComicDataEntity
import com.example.giuseppe.demoapp.usecases.MainUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class MainViewModel @Inject constructor(var mainUseCase: MainUseCase) : BaseViewModel() {
    private var comicMutableLiveData = MutableLiveData<MutableList<ComicDataEntity>>()
    private val disposables = CompositeDisposable()
    private var offsetCounter = 0


    val comicData: MutableLiveData<MutableList<ComicDataEntity>>
        get() {
            getComicList()
            return comicMutableLiveData
        }

    private fun getComicList() {
        getData()?.let { disposables.add(it) }
    }

    private fun getData(): Disposable? {
        return mainUseCase.getData()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doFinally { Timber.d("Ha terminado la carga") }
            ?.onErrorReturnItem(mutableListOf())
            ?.subscribe {
                comicMutableLiveData.value = it
            }
    }

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }

    fun loadMoreData(): Disposable? {
        offsetCounter++
        return mainUseCase.getData(offsetCounter.times(100))
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doFinally { Timber.d("Ha terminado la carga") }
            ?.onErrorReturnItem(comicMutableLiveData.value)
            ?.subscribe {
                comicMutableLiveData.value?.addAll(it)
                comicMutableLiveData.postValue(comicMutableLiveData.value)
            }
    }

}