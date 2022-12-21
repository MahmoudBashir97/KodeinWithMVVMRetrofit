package com.example.kodeinexamplemvvmretrofit.realDb.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.CoroutinesRoom
import com.example.kodeinexamplemvvmretrofit.realDb.data.model.Item
import com.example.kodeinexamplemvvmretrofit.realDb.data.repository.ItemRepository
import kotlinx.coroutines.launch

class ItemViewModel(app:Application,private val repo:ItemRepository): AndroidViewModel(app) {


    init {
        addNewItem(Item(0,"mmmmm"))
    }
    fun addNewItem(item: Item){
        viewModelScope.launch {
            repo.insertItems(item)
        }
    }

    fun getAllItems():LiveData<List<Item>> = repo.getAllItems()
}