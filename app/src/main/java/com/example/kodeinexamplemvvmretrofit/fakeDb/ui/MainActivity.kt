package com.example.kodeinexamplemvvmretrofit.fakeDb.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.kodeinexamplemvvmretrofit.R
import com.example.kodeinexamplemvvmretrofit.databinding.ActivityMainBinding
import com.thanosfisherman.wifiutils.WifiUtils
import com.thanosfisherman.wifiutils.wifiConnect.ConnectionErrorCode
import com.thanosfisherman.wifiutils.wifiConnect.ConnectionSuccessListener
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity() , KodeinAware{
    lateinit var binding:ActivityMainBinding

    override val kodein by closestKodein() // it is define like used inside MyApp ...
    private val viewModelFactory by instance<QuotesViewModelFactory>()
    private val viewModel: QuotesViewModel by instance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)
       // viewModel =ViewModelProvider(this,viewModelFactory)[QuotesViewModel::class.java]

        checkConnectedWfi()

        viewModel.getQuotes().observe(this){quotes->
            quotes.forEach { quote->
                Log.d("??????","currentQuote : $quote")
            }
        }
    }

    private fun showToastMsg(Msg:String){
        Toast.makeText(this,Msg,Toast.LENGTH_LONG).show()
    }

    private fun checkConnectedWfi() {
        binding.checkWifi.setOnClickListener{
            //todo this only for checking if connected to any wifi or not
           /* if(WifiUtils.withContext(this@MainActivity).isWifiConnected){
               showToastMsg("Connected right")
            }else showToastMsg("Not Connected")*/

            if(WifiUtils.withContext(this@MainActivity).isWifiConnected(names.M7mod.toString())){
                showToastMsg("Connected right")
            }else showToastMsg("Not Connected")

//            WifiUtils.withContext(this@MainActivity)
//                .connectWith(names.Ghaly.name,"123456789m")
//                .onConnectionResult(object:ConnectionSuccessListener{
//                    override fun success() {
//                        showToastMsg("Connected right")
//                    }
//
//                    override fun failed(errorCode: ConnectionErrorCode) {
//                        showToastMsg("failure ${errorCode.name}")
//                        Log.d("?????","operationWifi : ${errorCode.name}")
//                    }
//                })
        }
    }
}

enum class names{
    Ghaly ,
    M7mod
}