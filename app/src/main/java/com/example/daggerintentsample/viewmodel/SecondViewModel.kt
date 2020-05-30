package com.example.daggerintentsample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.daggerintentsample.data.SecondRepository
import com.example.daggerintentsample.data.entity.SampleData

class SecondViewModel(data: SampleData?, repository: SecondRepository) : ViewModel() {

    val text = MutableLiveData<String>()

    init {
        if (data != null) {
            text.value = "Sample data is not null"
        } else {
            text.value = "Sample data is null"
        }
    }
}