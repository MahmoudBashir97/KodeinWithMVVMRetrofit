package com.example.kodeinexamplemvvmretrofit.base

import android.app.Application
import android.content.Context
import org.kodein.di.KodeinAware
import org.kodein.di.LazyKodein

abstract class BaseApplication : Application() , KodeinAware{
    protected abstract fun createKodein(context: Context):LazyKodein
    protected abstract fun resetKodein()

    companion object{
        lateinit var app:BaseApplication
        fun getKodein() = app.kodein
        fun resetKodein() = app.resetKodein()
    }
}