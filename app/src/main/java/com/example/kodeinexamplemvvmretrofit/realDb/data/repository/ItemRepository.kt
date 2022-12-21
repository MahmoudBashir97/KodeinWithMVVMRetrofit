package com.example.kodeinexamplemvvmretrofit.realDb.data.repository

import androidx.lifecycle.LiveData
import com.example.kodeinexamplemvvmretrofit.realDb.data.db.ItemDatabase
import com.example.kodeinexamplemvvmretrofit.realDb.data.model.Item

class ItemRepository(private val db:ItemDatabase) {

    suspend fun insertItems(item: Item) = db.dao().insertItems(item)

    suspend fun delete(item: Item) = db.dao().delete(item)

    fun getAllItems(): LiveData<List<Item>> = db.dao().getAllItems()
}