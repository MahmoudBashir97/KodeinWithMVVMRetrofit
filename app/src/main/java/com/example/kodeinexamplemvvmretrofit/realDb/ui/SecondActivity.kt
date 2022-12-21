package com.example.kodeinexamplemvvmretrofit.realDb.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kodeinexamplemvvmretrofit.R
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class SecondActivity : AppCompatActivity(),KodeinAware{
    override val kodein by closestKodein()
    private val factory by instance<ItemViewModelFactory>()
    private val viewModel:ItemViewModel by instance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getAllItems().observe(this){
            mlist->
            if (mlist.isNotEmpty()) Log.d("????? ","listSize : ${mlist.size}")
        }
    }
}