package com.example.kodeinexamplemvvmretrofit.realDb.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kodeinexamplemvvmretrofit.realDb.data.model.Item

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItems(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Query("SELECT * FROM product_item")
    fun getAllItems():LiveData<List<Item>>
}