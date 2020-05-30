package com.example.daggerintentsample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.daggerintentsample.data.FirstRepository
import com.example.daggerintentsample.data.entity.SampleData
import javax.inject.Inject

class FirstViewModel @Inject constructor(id: String?, repository: FirstRepository): ViewModel() {

    val dataString = MutableLiveData<String>()

    val _toNext = MutableLiveData<SampleData>()

    init {
        dataString.value = repository.getData(id)
    }

    fun onButtonClick() {
        _toNext.value = SampleData("Title1", "hogehuga")
    }
}