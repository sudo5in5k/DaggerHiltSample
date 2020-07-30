package com.example.daggerintentsample.data

import android.content.Context
import com.example.daggerintentsample.R
import org.jetbrains.annotations.NotNull
import javax.inject.Inject
import javax.inject.Singleton

class FirstRepository @Inject constructor(private val context: Context) {

    fun getData(id: String?) = "${context.getString(R.string.app_name)}: This is First Repository (ver. $id)"
}