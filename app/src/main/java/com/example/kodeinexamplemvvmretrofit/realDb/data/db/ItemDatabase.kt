package com.example.kodeinexamplemvvmretrofit.realDb.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kodeinexamplemvvmretrofit.realDb.data.model.Item
import java.util.concurrent.locks.Lock

@Database(
    entities = [Item::class], version = 1
)
abstract class ItemDatabase :RoomDatabase(){
    abstract fun dao():ItemDao

//    companion object{
//        @Volatile
//        private var instance : ItemDatabase? = null
//        private val Lock = Any()
//        operator fun invoke(context: Context) = instance?: synchronized(lock = Lock){
//            instance?: createDatabase(context).also { instance = it }
//        }//this fun is (executed)created when we get an instance of itemDatabase
//        private fun createDatabase(context: Context) =
//            Room.databaseBuilder(
//                context.applicationContext,
//                ItemDatabase::class.java,
//                "item_db"
//            ).build()
//    }
}