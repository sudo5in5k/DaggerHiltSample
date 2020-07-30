package com.example.daggerintentsample.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.daggerintentsample.data.FirstRepository
import com.example.daggerintentsample.data.entity.SampleData
import javax.inject.Inject

class FirstViewModel @ViewModelInject constructor(
    id: String?,
    private val repository: FirstRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val dataString = MutableLiveData<String>()

    val _toNext = MutableLiveData<SampleData>()

    init {
        dataString.value = repository.getData(id)
    }

    fun onButtonClick() {
        _toNext.value = SampleData("Title1", "hogehuga")
    }
}