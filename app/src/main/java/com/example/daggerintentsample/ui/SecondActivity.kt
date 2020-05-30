package com.example.daggerintentsample.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.daggerintentsample.R
import com.example.daggerintentsample.data.entity.SampleData
import com.example.daggerintentsample.databinding.ActivitySecondBinding
import com.example.daggerintentsample.di.ViewModelFactory
import com.example.daggerintentsample.viewmodel.SecondViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class SecondActivity : AppCompatActivity() {

    @Inject
    lateinit var secondViewModelFactory: ViewModelFactory
    private lateinit var secondViewModel: SecondViewModel
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second)
        //secondViewModelFactory = SecondViewModelFactory(data, repository)
        secondViewModel =
            ViewModelProvider(this, secondViewModelFactory).get(SecondViewModel::class.java)

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