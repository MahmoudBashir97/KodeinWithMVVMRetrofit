package com.example.kodeinexamplemvvmretrofit.fakeDb.data.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kodeinexamplemvvmretrofit.fakeDb.data.model.Quote

class QuoteDaoImpl : QuoteDao {

    private val quoteList = mutableListOf<Quote>()
    private val quotes = MutableLiveData<List<Quote>>()
    init {
        quotes.value = quoteList
    }
    override fun addQuote(quote: Quote) {
        quoteList.add(quote)
    }

    override fun getAllQuotes(): LiveData<List<Quote>> =quotes


}