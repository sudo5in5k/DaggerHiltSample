package com.example.daggerintentsample.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.daggerintentsample.R
import com.example.daggerintentsample.databinding.ActivityFirstBinding
import com.example.daggerintentsample.viewmodel.FirstViewModel
import com.example.daggerintentsample.viewmodel.FirstViewModelFactory
import dagger.android.AndroidInjection
import javax.inject.Inject

class FirstActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: FirstViewModelFactory
    private lateinit var firstViewModel: FirstViewModel
    private lateinit var binding: ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_first)

        firstViewModel = ViewModelProvider(this, factory).get(FirstViewModel::class.java)

        binding.apply {
            viewModel = firstViewModel
        }

        firstViewModel.dataString.observe(this, Observer {
            Log.d("debug", it)
        })

        firstViewModel._toNext.observe(this, Observer {
            val intent = SecondActivity.createIntent(this, it)
            startActivity(intent)
        })
    }
}