package com.handroid.netpixy

import android.content.ClipData
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


class IntentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)
        var TAG = applicationInfo.className
        Log.d(TAG,TAG+" Oncreate")
//        Log.d(TAG,"data:" + intent.clipData)

        when {
            intent?.action == Intent.ACTION_SEND -> {
                var data = intent.clipData


//                Log.d(TAG,"ACTION_SEND : " + data?.getItemAt(1))
//                Log.d(TAG,"ACTION_SEND : " + data?.getItemAt(2))

                if ("text/plain" == intent.type) {
                    if (data != null) {
                        Log.d(TAG,"ACTION_SEND : " + data.getItemAt(0).text)
                        finish()
                    }
                    intent.getStringExtra(Intent.EXTRA_TEXT)?.let {
                        // Update UI to reflect text being shared
                    }
//                    Log.d(TAG,"Intent.EXTRA_TEXT : "+Intent.EXTRA_TEXT)
                }
            }
            else -> {
                // Handle other intents, such as being started from the home screen
            }
        }
    }
}