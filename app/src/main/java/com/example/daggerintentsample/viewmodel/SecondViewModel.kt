package com.example.daggerintentsample.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.daggerintentsample.data.SecondRepository
import com.example.daggerintentsample.data.entity.SampleData
import javax.inject.Inject

class SecondViewModel @ViewModelInject constructor(
    data: SampleData?,
    repository: SecondRepository,
    @Assisted savedStateHandle: SavedStateHandle
) : ViewModel() {

    val text = MutableLiveData<String>()

    init {
        if (data != null) {
            text.value = data.title
        } else {
            text.value = "Sample data is null"
        }
    }
}