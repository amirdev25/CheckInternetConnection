package uz.amirdev.checkconnection

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.lifecycle.LiveData

@SuppressLint("StaticFieldLeak")
object CheckConnection : LiveData<Boolean>() {

    private var broadcastReceiver: BroadcastReceiver? = null
    private var context: Context? = null
    fun init(context: Context) {
        this.context = context
    }
//ok_repo 
    private fun prepareNetwork(context: Context) {
        val intentFilter = IntentFilter()
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION)
        //creating broadcastreceiver
        broadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(p0: Context?, intent: Intent?) {
                val connectivityManager =
                    context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                //getting connection networks
                val allNetworks = connectivityManager.allNetworks
                //checking connection
                value = allNetworks.isNotEmpty()
            }
        }
        context.registerReceiver(broadcastReceiver, intentFilter)
    }


    override fun onActive() {
        prepareNetwork(context!!)
    }

    override fun onInactive() {
        context?.unregisterReceiver(broadcastReceiver)
        broadcastReceiver = null
    }
}