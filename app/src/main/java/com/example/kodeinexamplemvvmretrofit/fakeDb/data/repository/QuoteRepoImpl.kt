package com.example.kodeinexamplemvvmretrofit.fakeDb.data.repository

import androidx.lifecycle.LiveData
import com.example.kodeinexamplemvvmretrofit.fakeDb.data.db.QuoteDao
import com.example.kodeinexamplemvvmretrofit.fakeDb.data.model.Quote

class QuoteRepoImpl(private val dao: QuoteDao): QuoteRepository {
    override fun addQuote(quote: Quote) = dao.addQuote(quote)

    override fun getAllQuotes(): LiveData<List<Quote>> = dao.getAllQuotes()

}