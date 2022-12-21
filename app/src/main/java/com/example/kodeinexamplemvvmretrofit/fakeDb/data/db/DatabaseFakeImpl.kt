package com.example.kodeinexamplemvvmretrofit.fakeDb.data.db

class DatabaseFakeImpl: Database {
    override val quoteDao: QuoteDao
        get() = QuoteDaoImpl()
}