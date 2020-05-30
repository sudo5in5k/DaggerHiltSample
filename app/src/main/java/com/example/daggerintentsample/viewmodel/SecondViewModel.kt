package com.example.daggerintentsample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.daggerintentsample.data.SecondRepository
import com.example.daggerintentsample.data.entity.SampleData
import javax.inject.Inject

class SecondViewModel @Inject constructor(data: SampleData?, repository: SecondRepository) : ViewModel() {

    val text = MutableLiveData<String>()

    init {
        if (data != null) {
            text.value = data.title
        } else {
            text.value = "Sample data is null"
        }
    }
}