package com.example.kodeinexamplemvvmretrofit.fakeDb.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kodeinexamplemvvmretrofit.fakeDb.data.repository.QuoteRepository

class QuotesViewModelFactory(private val app:Application,private val repo: QuoteRepository)
    : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuotesViewModel(app,repo) as T
    }
}