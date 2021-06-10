package com.handroid.netpixy

import android.app.PictureInPictureParams
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class PipActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pip)


        var btnSet = findViewById<Button>(R.id.btnSet)
        var btnUndo = findViewById<Button>(R.id.btnUndo)

        btnUndo.setOnClickListener {
            try {
                Settings.Global.putInt(
                    baseContext.contentResolver,"bold_text",0
                )
            }catch (e:java.lang.Exception){
                e.printStackTrace()
            }
        }

        btnSet.setOnClickListener {
            try {
                Settings.Global.putInt(
                    baseContext.contentResolver,"bold_text",700
                )
            }catch (e:java.lang.Exception){
                e.printStackTrace()
            }
        }
    }

    override fun onUserLeaveHint() {
        println("override onUserLeaveHint")
        if(Build.VERSION.SDK_INT>=26){
            var pipParam = PictureInPictureParams.Builder()
            enterPictureInPictureMode(pipParam.build())
        }

    }

    override fun onPictureInPictureModeChanged(
        isInPictureInPictureMode: Boolean,
        newConfig: Configuration?
    ) {

    }
}