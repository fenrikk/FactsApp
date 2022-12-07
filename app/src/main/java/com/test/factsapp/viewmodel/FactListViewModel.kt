package com.test.factsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.test.factsapp.data.FactApi
import com.test.factsapp.data.model.FactData
import com.test.factsapp.other.FETCH_VALUE
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class FactListViewModel(var factApi: FactApi): BaseViewModel() {

    private val factData = MutableLiveData<List<FactData>>()

    init {
        fetchFacts()
    }

    fun fetchFacts(){
        factApi.getFacts(FETCH_VALUE)
            .map { it.data }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val currentData = factData.value ?: emptyList()
                factData.value = currentData + it
            }, {
                it.printStackTrace()
            }).autoDispose()
    }

    fun getFactData(): LiveData<List<FactData>>{
        return factData
    }
}