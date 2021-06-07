package com.handroid.pipfont

import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.Player.EventListener
import com.google.android.exoplayer2.ui.PlayerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class VideoActivity : AppCompatActivity() {
    lateinit var inTvOne:TextView
    lateinit var inTvTwo:TextView
    lateinit var inIv:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("VideoActivity","onCreate"+"#########")
        setContentView(R.layout.activity_video)
        println("tttttttt")
        var player:SimpleExoPlayer = SimpleExoPlayer.Builder(this).build()
        var playerView = findViewById<PlayerView>(R.id.playerview)
        playerView.setPlayer(player)
        var url = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
        var mediaItem:MediaItem = MediaItem.fromUri(Uri.parse(url))

        var eventListener = object :Player.EventListener{
            override fun onEvents(player: Player, events: Player.Events) {
                super.onEvents(player, events)
            }

            override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
//                super.onPlayerStateChanged(playWhenReady, playbackState)

                println("playbackState : " +playbackState)
            }
        }

        inTvOne = findViewById<TextView>(R.id.inTvOne)
        inTvTwo = findViewById<TextView>(R.id.inTvTwo)
        inIv = findViewById<ImageView>(R.id.imageView)

        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

        player.addListener(eventListener)
        player.videoScalingMode = C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING

        player.setMediaItem(mediaItem)
        player.prepare()
        player.play()

        CoroutineScope(Main).launch{
            inTvOne.setText("Crt One")
            inTvTwo.setText("Two!!")
//            inIv.setImageResource(R.drawable.iconf)
            var temp = 0
            System.out.println("in CoroutinScope")
//            while (true) {
//                temp++
//                inTvOne.setText("Coroutine"+temp)
//                if (temp==10000000){
//                    break;
//                }
//            }
        }




//        var btn = findViewById<Button>(R.id.videoButton)
//        btn.setOnClickListener {
//            println("tttttttt")
//        }
    }

    override fun onUserLeaveHint() {
        println("override onUserLeaveHint")
//        var inTvOne = findViewById<TextView>(R.id.inTvOne)
//        var inTvTwo = findViewById<TextView>(R.id.inTvTwo)

        inTvOne.setText("One!!")
        inTvTwo.setText("Two!!")
        if(Build.VERSION.SDK_INT>=26){
            enterPictureInPictureMode()
        }

    }

    override fun onPictureInPictureModeChanged(
        isInPictureInPictureMode: Boolean,
        newConfig: Configuration?
    ) {
//        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig)
//        var inTvOne = findViewById<TextView>(R.id.inTvOne)
//        var inTvTwo = findViewById<TextView>(R.id.inTvTwo)
        Log.d("VideoActivity","isInPictureInPictureMode : "+isInPictureInPictureMode)
            CoroutineScope(Main).launch{
                if(isInPictureInPictureMode){
                    inTvOne.setText("in One!!TT")
                    inTvTwo.setText("in Two!!")
                }else{
                    inTvOne.setText("in One!!FF")

                }
            }
    }


    override fun onStart() {
        super.onStart()
        Log.d("VideoActivity","onStart"+"#########")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("VideoActivity","onRestart"+"#########")
    }

    override fun onResume() {
        super.onResume()
        Log.d("VideoActivity","onResume"+"#########")
    }

    override fun onPause() {
        super.onPause()
        Log.d("VideoActivity","onPause"+"#########")
    }

    override fun onStop() {
        super.onStop()
        Log.d("VideoActivity","onStop"+"#########")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("VideoActivity","onDestroy"+"#########")
    }
}