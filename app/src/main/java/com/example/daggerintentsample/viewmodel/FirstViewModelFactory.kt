package com.example.daggerintentsample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.daggerintentsample.data.FirstRepository
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class FirstViewModelFactory @Inject constructor(private val id: String?, private val repository: FirstRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FirstViewModel::class.java)) {
            return FirstViewModel(id, repository) as T
        } else {
            throw IllegalArgumentException("FirstViewModel not found.")
        }
    }
}