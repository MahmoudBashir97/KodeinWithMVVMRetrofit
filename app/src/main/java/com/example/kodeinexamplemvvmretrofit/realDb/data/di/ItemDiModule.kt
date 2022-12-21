package com.example.kodeinexamplemvvmretrofit.realDb.data.di

import android.content.Context
import androidx.room.Room
import com.example.kodeinexamplemvvmretrofit.realDb.Application2
import com.example.kodeinexamplemvvmretrofit.realDb.data.db.ItemDatabase
import com.example.kodeinexamplemvvmretrofit.realDb.data.repository.ItemRepository
import com.example.kodeinexamplemvvmretrofit.realDb.ui.ItemViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

fun itemModule(context: Context)=Kodein.Module("itemModule"){
    bind<ItemDatabase>() with  singleton {
        Room.databaseBuilder(context,
        ItemDatabase::class.java,
        "item_db")
            .build()
    }
    bind() from singleton { ItemRepository(instance()) }
    bind() from singleton { ItemViewModel(context.applicationContext as Application2,instance()) }
}