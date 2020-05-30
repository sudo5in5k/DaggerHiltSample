package com.example.daggerintentsample.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.daggerintentsample.R
import com.example.daggerintentsample.data.SecondRepository
import com.example.daggerintentsample.data.entity.SampleData
import com.example.daggerintentsample.databinding.ActivitySecondBinding
import com.example.daggerintentsample.viewmodel.SecondViewModel
import com.example.daggerintentsample.viewmodel.SecondViewModelFactory

class SecondActivity : AppCompatActivity() {

    private val repository = SecondRepository(this)
    private val data: SampleData? by lazy { intent.getSerializableExtra(KEY) as? SampleData }
    private lateinit var secondViewModelFactory: SecondViewModelFactory
    private lateinit var secondViewModel: SecondViewModel
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second)
        secondViewModelFactory = SecondViewModelFactory(data, repository)
        secondViewModel =
            ViewModelProvider(this, secondViewModelFactory).get(SecondViewModel::class.java)

        binding.apply {
            viewModel = secondViewModel
        }
    }

    companion object {
        private const val KEY = "key"

        fun createIntent(context: Context, data: SampleData?) =
            Intent(context, SecondActivity::class.java).apply {
                data?.let {
                    putExtra(KEY, it)
                }
            }
    }
}