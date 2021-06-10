package com.handroid.netpixy

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.provider.Settings.System.FONT_SCALE
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var TAG = applicationInfo.className


        var btn = findViewById<Button>(R.id.button)
        var systembtn1 = findViewById<Button>(R.id.systembtn1)
        var systembtn2 = findViewById<Button>(R.id.systembtn2)
        var systembtn3 = findViewById<Button>(R.id.systembtn3)
        var restartbtn = findViewById<Button>(R.id.restartbtn)
        var pipbtn = findViewById<Button>(R.id.pipbtn)
        var systembtnb = findViewById<Button>(R.id.systembtnb)
        var bold = findViewById<Button>(R.id.bold)
        var scale = findViewById<Button>(R.id.scale)
        var bs = findViewById<TextView>(R.id.bold_status)
        var ss = findViewById<TextView>(R.id.scale_status)

        btn.setOnClickListener { it: View? ->
            var send = Intent(this, VideoActivity::class.java)
            this.startActivity(send)
        }
        systembtn1.setOnClickListener {
            //android get font size
            var scale = resources.configuration.fontScale

//            var uim : android.app.UiModeManager
//            uim.nightMode

            //android setting call
//            val intent = Intent(Settings.ACTION_NIGHT_DISPLAY_SETTINGS)
//            Settings.Global.putInt(getContentResolver(), Settings.System.FONT_SCALE,5)
            try {
                Log.d(TAG,"Settings.System.FONT_SCALE : "+Settings.System.FONT_SCALE)
    //            Settings.System.putFloat(
    //                baseContext.contentResolver,
    //                FONT_SCALE, 1.0.toFloat()
    //            )

                println("Settings.System.FONT_SCALE : "+resources.configuration.fontScale)

                Settings.System.putFloat(
                    baseContext.contentResolver,
                    FONT_SCALE, 1.0.toFloat())

                println("Settings.System.FONT_SCALE : "+resources.configuration.fontScale)

                val intent = Intent(Settings.Global.WINDOW_ANIMATION_SCALE)

//                startActivity(intent)
            }catch (e:Exception){
                Log.d(TAG,"E : "+e.toString())
                e.printStackTrace()
            }
//            startActivityForResult(intent, 0)

//            val accessibility_intent = Intent(
//                Settings.ACTION_ACCESSIBILITY_SETTINGS,
//                Uri.parse("package:$packageName")
//            )
//            accessibility_intent.setClassName("com.android.settings","com.android.settings.Settings")
////            Settings.Secure.putString(getContentResolver(), Settings.Secure.ACCESSIBILITY_DISPLAY_INVERSION_ENABLED, "1");
//            startActivity(Intent(accessibility_intent))
        }

        systembtn2.setOnClickListener {
            try {
                println("Settings.System.FONT_SCALE : "+resources.configuration.fontScale)
                Settings.System.putFloat(
                    baseContext.contentResolver,
                    FONT_SCALE, 2.0.toFloat())
                println("Settings.System.FONT_SCALE : "+resources.configuration.fontScale)
            }catch (e:Exception){
                e.printStackTrace()
            }
        }

        systembtn3.setOnClickListener {
            try {
                println("Settings.System.FONT_SCALE : "+resources.configuration.fontScale)
                Settings.System.putFloat(
                    baseContext.contentResolver,
                    FONT_SCALE, 0.9.toFloat())
                println("Settings.System.FONT_SCALE : "+resources.configuration.fontScale)
            }catch (e:Exception){
                e.printStackTrace()
            }
        }

        restartbtn.setOnClickListener {
//            var intentToNew:Intent = Intent(this, VideoActivity::class.java)
            val componentName =
                packageManager.getLaunchIntentForPackage("com.netflix.mediaclient")!!.component
//            val intent: Intent = makeRestartActivityTask(componentName)
//            val intent: Intent = IntentCompat.makeMainSelectorActivity(componentName)

//            startActivity(intent)
//            startActivity(intentToNew)

            val intent = Intent(Intent.ACTION_VIEW)
            intent.setClassName(
                "com.netflix.mediaclient",
                "com.netflix.mediaclient.ui.player.PlayerActivity"
//                "com.handroid.pipfont",
//                "com.handroid.pipfont.VideoActivity"
            )
            startActivity(intent);

        }

        pipbtn.setOnClickListener { it: View? ->
            var send = Intent(this, PipActivity::class.java)
            this.startActivity(send)
        }

        systembtnb.setOnClickListener {
//            Settings.System.putFloat(
//                baseContext.contentResolver,
//                "bold_text", 1.0.toFloat())

            try {
                var boldSetting = Settings.Global.getInt(baseContext.contentResolver,"bold_text");
                Log.d(TAG,"bold_text : "+Settings.Global.getInt(baseContext.contentResolver,"bold_text"))
//                Toast.makeText(this,""+Settings.Global.getInt(baseContext.contentResolver,"bold_text"),Toast.LENGTH_SHORT)
                Settings.Global.putInt(
                    baseContext.contentResolver,"bold_text",0
                )
                Settings.Global.putInt(
                    baseContext.contentResolver,"bold_text",boldSetting
                )
            }catch (e:java.lang.Exception){
                e.printStackTrace()
            }
        }

        bold.setOnClickListener {
            try {
                var boldSetting = Settings.Global.getInt(baseContext.contentResolver, "bold_text");
                Log.d("MainActivity", "systembtnc : " + boldSetting)
                var flag = false
                when (boldSetting) {
                    0 -> {
                        flag = Settings.Global.putInt(
                            baseContext.contentResolver, "bold_text", 1
                        )
                        flag = Settings.Global.putInt(
                            baseContext.contentResolver, "bold_text", 1
                        )
                        Log.d("MainActivity", "################## 00000")

                    }
                    else -> {
                        flag = Settings.Global.putInt(
                            baseContext.contentResolver, "bold_text", 0
                        )
                        flag = Settings.Global.putInt(
                            baseContext.contentResolver, "bold_text", 0
                        )
                        Log.d("MainActivity", "##################else")

                    }

                }
                Log.d("MainActivity", "##################1")
                if (flag) {
//                    Log.d("MainActivity", "flag : " + flag)
//                    Timer("SettingUp", false).schedule(500) {
//                        Settings.Global.putInt(
//                            baseContext.contentResolver, "bold_text", boldSetting
//                        )
//                    }
                    Settings.Global.putInt(
                        baseContext.contentResolver, "bold_text", boldSetting
                    )
                }
                Log.d("MainActivity", "##################2")
            }catch (e:java.lang.Exception){
                e.printStackTrace()
            }
        }

        scale.setOnClickListener {
            Settings.System.putFloat(
                baseContext.contentResolver,
                FONT_SCALE, 1.0.toFloat()
            )
        }

        try{
//            Settings.System.putFloat(
//                baseContext.contentResolver,
//                FONT_SCALE, 1.0.toFloat()
//            )
            ss.setText("scale status : "+ Settings.System.getFloat(baseContext.contentResolver, FONT_SCALE))
            bs.setText("bold status : "+ Settings.Global.getInt(baseContext.contentResolver,"bold_text"))
//            Settings.System.getInt()
        }catch (e:java.lang.Exception){
            e.printStackTrace()
        }
    }

    override fun startActivityForResult(intent: Intent?, requestCode: Int) {
        super.startActivityForResult(intent, requestCode)
        if(requestCode==0){
            Log.d("MainActivity", "requestCode : "+requestCode)
        }
    }

//    override fun onUserLeaveHint() {
//        println("override onUserLeaveHint")
//        if(Build.VERSION.SDK_INT>=26){
//            enterPictureInPictureMode()
//        }
//
//    }
//
//    override fun onPictureInPictureModeChanged(
//        isInPictureInPictureMode: Boolean,
//        newConfig: Configuration?
//    ) {
//
//    }
}