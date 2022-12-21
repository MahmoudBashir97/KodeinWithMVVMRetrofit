package com.example.kodeinexamplemvvmretrofit.realDb.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_item")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val name:String
)