package com.example.daggerintentsample.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.daggerintentsample.R
import com.example.daggerintentsample.data.entity.SampleData
import com.example.daggerintentsample.databinding.ActivitySecondBinding
import com.example.daggerintentsample.viewmodel.SecondViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SecondActivity : AppCompatActivity() {

    private val secondViewModel by viewModels<SecondViewModel>()
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second)
        binding.apply {
            viewModel = secondViewModel
        }
    }

    companion object {
        const val KEY = "key"

        fun createIntent(context: Context, data: SampleData?) =
            Intent(context, SecondActivity::class.java).apply {
                data?.let {
                    putExtra(KEY, it)
                }
            }
    }
}