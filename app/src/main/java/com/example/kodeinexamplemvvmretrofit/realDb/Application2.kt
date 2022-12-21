package com.example.kodeinexamplemvvmretrofit.realDb

import android.app.Application
import android.content.Context
import com.example.kodeinexamplemvvmretrofit.base.BaseApplication
import com.example.kodeinexamplemvvmretrofit.fakeDb.data.di.appModule
import com.example.kodeinexamplemvvmretrofit.realDb.data.db.ItemDatabase
import com.example.kodeinexamplemvvmretrofit.realDb.data.di.itemModule
import com.example.kodeinexamplemvvmretrofit.realDb.data.repository.ItemRepository
import com.example.kodeinexamplemvvmretrofit.realDb.ui.ItemViewModel
import com.example.kodeinexamplemvvmretrofit.realDb.ui.ItemViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.LazyKodein


class Application2 : Application() , KodeinAware {
    override var kodein = createKodein(this@Application2)

    private fun createKodein(context: Context):LazyKodein{
        return Kodein.lazy {
            import(itemModule(context))
        }
    }
}
//class Application2  : Application() ,KodeinAware{
//    override val kodein: Kodein  = Kodein.lazy {
//        import(androidXModule(this@Application2))
//        bind() from singleton { ItemDatabase(instance()) }
//        bind() from singleton { ItemRepository(instance()) }
//        bind() from provider { ItemViewModelFactory(instance()) }
//        bind() from provider { ItemViewModel(instance()) }
//    }
//}