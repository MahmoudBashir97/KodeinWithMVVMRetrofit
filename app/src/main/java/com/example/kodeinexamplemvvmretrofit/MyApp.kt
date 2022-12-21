package com.example.kodeinexamplemvvmretrofit

import android.app.Application
import android.content.Context
import android.provider.ContactsContract.Data
import com.example.kodeinexamplemvvmretrofit.base.BaseApplication
import com.example.kodeinexamplemvvmretrofit.fakeDb.data.db.Database
import com.example.kodeinexamplemvvmretrofit.fakeDb.data.db.DatabaseFakeImpl
import com.example.kodeinexamplemvvmretrofit.fakeDb.data.db.QuoteDao
import com.example.kodeinexamplemvvmretrofit.fakeDb.data.db.QuoteDaoImpl
import com.example.kodeinexamplemvvmretrofit.fakeDb.data.di.appModule
import com.example.kodeinexamplemvvmretrofit.fakeDb.data.repository.QuoteRepoImpl
import com.example.kodeinexamplemvvmretrofit.fakeDb.data.repository.QuoteRepository
import com.example.kodeinexamplemvvmretrofit.fakeDb.ui.QuotesViewModel
import com.example.kodeinexamplemvvmretrofit.fakeDb.ui.QuotesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.LazyKodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MyApp: BaseApplication() {

    override fun createKodein(context: Context) : LazyKodein {
        return Kodein.lazy {
            import(appModule(context))
        }
    }

    override fun resetKodein() {
        kodein= createKodein(this)
    }

    override fun onCreate() {
        super.onCreate()
        app = this
    }

    override var kodein = createKodein(this@MyApp)
}
//class MyApp:Application(), KodeinAware {
//    override val kodein = Kodein.lazy {
//        bind<Database>() with singleton {DatabaseFakeImpl()}
//        //bind<QuoteDao>() with singleton { QuoteDaoImpl() }
//        bind<QuoteDao>() with singleton { instance<Database>().quoteDao}
//        bind<QuoteRepository>() with singleton { QuoteRepoImpl(instance()) }
//        //bind<QuotesViewModelFactory>() with provider { QuotesViewModelFactory(instance()) } //todo creating an instance in each call Vs singleton
//        bind() from provider { QuotesViewModelFactory(instance()) } //todo creating an instance in each call Vs singleton
//        bind() from singleton { QuotesViewModel(this@MyApp,instance()) }
//    }
//}