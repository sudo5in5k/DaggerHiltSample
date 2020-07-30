package com.example.daggerintentsample.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.daggerintentsample.R
import com.example.daggerintentsample.data.FirstRepository
import com.example.daggerintentsample.databinding.ActivityFirstBinding
import com.example.daggerintentsample.viewmodel.FirstViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FirstActivity : AppCompatActivity() {

//    @Inject
//    lateinit var repository: FirstRepository

    @Inject
    @JvmField
    var id: String? = null

    @Inject
    lateinit var repository: FirstRepository

    private val firstViewModel: FirstViewModel by viewModels()
    private lateinit var binding: ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_first)
        binding.apply {
            viewModel = firstViewModel
        }

        Log.d("debug", id ?: "null")
        firstViewModel.dataString.observe(this, Observer {
            Log.d("debug", it)
        })

        firstViewModel._toNext.observe(this, Observer {
            val intent = SecondActivity.createIntent(this, it)
            startActivity(intent)
        })
    }
}