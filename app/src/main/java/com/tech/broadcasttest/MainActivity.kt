package com.tech.broadcasttest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var text:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text=findViewById(R.id.text)

        var filter=IntentFilter()
        filter.addAction(Intent.ACTION_POWER_CONNECTED)
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED)
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        filter.addAction(Intent.ACTION_SCREEN_ON)
        filter.addAction(Intent.ACTION_SCREEN_OFF)
        filter.addAction(Intent.ACTION_BATTERY_LOW)
        filter.addAction(Intent.ACTION_BATTERY_OKAY)
        filter.addAction(Intent.ACTION_HEADSET_PLUG)



registerReceiver(MyBroadcast(text!!),filter)

    }

//inner class
    class MyBroadcast(val tv:TextView):BroadcastReceiver()
    {

        override fun onReceive(context: Context?, intent: Intent?) {

            if(intent?.action!!.contains("SCREEN_ON"))
            {

                tv.setText("welcome dnyaneshwar")
            }else if(intent?.action!!.contains("AIRPLANE"))

            {
              tv.setText("hello this is airplane mode")
            }else
            {
                tv.setText(intent?.action)
            }
        }
    }

}

