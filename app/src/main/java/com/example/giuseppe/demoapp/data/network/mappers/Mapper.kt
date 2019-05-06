package com.example.giuseppe.demoapp.data.network.mappers

import com.example.giuseppe.demoapp.data.network.response.ComicResponse
import io.reactivex.Flowable

interface Mapper<M,T> {
    fun map(entry: M): T?
}