package com.example.daggerintentsample.data

import android.content.Context
import com.example.daggerintentsample.R

class FirstRepository(private val context: Context) {

    fun getData(id: String?) = "${context.getString(R.string.app_name)}: This is First Repository (ver. $id)"
}