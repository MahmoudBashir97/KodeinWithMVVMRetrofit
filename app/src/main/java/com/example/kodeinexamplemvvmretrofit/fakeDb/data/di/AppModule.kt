package com.example.kodeinexamplemvvmretrofit.fakeDb.data.di

import android.content.Context
import com.example.kodeinexamplemvvmretrofit.MyApp
import com.example.kodeinexamplemvvmretrofit.fakeDb.data.db.Database
import com.example.kodeinexamplemvvmretrofit.fakeDb.data.db.DatabaseFakeImpl
import com.example.kodeinexamplemvvmretrofit.fakeDb.data.db.QuoteDao
import com.example.kodeinexamplemvvmretrofit.fakeDb.data.db.QuoteDaoImpl
import com.example.kodeinexamplemvvmretrofit.fakeDb.data.repository.QuoteRepoImpl
import com.example.kodeinexamplemvvmretrofit.fakeDb.data.repository.QuoteRepository
import com.example.kodeinexamplemvvmretrofit.fakeDb.ui.QuotesViewModel
import com.example.kodeinexamplemvvmretrofit.fakeDb.ui.QuotesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

fun appModule(appContext:Context): Kodein.Module{
    return Kodein.Module("appModule"){
        bind() from singleton { appContext }
        bind<Database>() with singleton { DatabaseFakeImpl() }
        bind<QuoteDao>() with singleton { QuoteDaoImpl() }
        bind<QuoteRepository>() with  singleton { QuoteRepoImpl(instance()) }
        bind() from provider { QuotesViewModelFactory(context as MyApp,instance()) }
        bind() from singleton { QuotesViewModel(appContext as MyApp,instance()) }
    }
}