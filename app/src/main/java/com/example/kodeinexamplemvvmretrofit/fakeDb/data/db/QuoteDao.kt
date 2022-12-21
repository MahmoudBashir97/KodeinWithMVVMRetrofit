package com.example.kodeinexamplemvvmretrofit.fakeDb.data.db

import androidx.lifecycle.LiveData
import com.example.kodeinexamplemvvmretrofit.fakeDb.data.model.Quote


interface QuoteDao {
    fun addQuote(quote: Quote)

    fun getAllQuotes():LiveData<List<Quote>>
}