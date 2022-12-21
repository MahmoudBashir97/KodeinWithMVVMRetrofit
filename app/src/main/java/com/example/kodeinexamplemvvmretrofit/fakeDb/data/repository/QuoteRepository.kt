package com.example.kodeinexamplemvvmretrofit.fakeDb.data.repository

import androidx.lifecycle.LiveData
import com.example.kodeinexamplemvvmretrofit.fakeDb.data.model.Quote

interface QuoteRepository {
    fun addQuote(quote: Quote)
    fun getAllQuotes(): LiveData<List<Quote>>
}