package com.example.daggerintentsample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.daggerintentsample.data.SecondRepository
import com.example.daggerintentsample.data.entity.SampleData

@Suppress("UNCHECKED_CAST")
class SecondViewModelFactory(
    private val data: SampleData?,
    private val repository: SecondRepository
) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SecondViewModel(data, repository) as T
    }
}