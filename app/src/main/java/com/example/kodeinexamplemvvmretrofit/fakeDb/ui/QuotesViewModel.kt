package com.example.kodeinexamplemvvmretrofit.fakeDb.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.kodeinexamplemvvmretrofit.fakeDb.data.model.Quote
import com.example.kodeinexamplemvvmretrofit.fakeDb.data.repository.QuoteRepository

class QuotesViewModel(private val app:Application,private val repo: QuoteRepository):AndroidViewModel(app){


    init {
        val q = Quote("MMMM","jkjkf eghf")
        addQuote(q)
    }
    fun addQuote(quote: Quote) = repo.addQuote(quote)

    fun getQuotes()=repo.getAllQuotes()
}