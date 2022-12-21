package com.example.kodeinexamplemvvmretrofit.realDb.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kodeinexamplemvvmretrofit.realDb.data.repository.ItemRepository

class ItemViewModelFactory(private val app:Application,private val repo:ItemRepository): ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ItemViewModel(app,repo) as T
    }
}