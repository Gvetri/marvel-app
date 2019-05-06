package com.example.giuseppe.demoapp.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.example.giuseppe.demoapp.data.network.response.ComicResponse
import com.example.giuseppe.demoapp.usecases.ComicDetailUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ComicDetailViewModel @Inject constructor(var comicDetailUseCase: ComicDetailUseCase) : BaseViewModel() {

    private var privateDetailLiveData = MutableLiveData<ComicResponse>()

    private val disposables = CompositeDisposable()

    fun getComicDetail(id: Int): MutableLiveData<ComicResponse> {
        getData(id)?.let { disposables.add(it) }
        return privateDetailLiveData
    }

    fun getData(id: Int): Disposable? {
        return comicDetailUseCase.getComicDetailData(id)?.subscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe {
                privateDetailLiveData.value = it
            }
    }
}